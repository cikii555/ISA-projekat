package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.AppointmentHistoryDTO;
import com.javaguide.ISAprojekat.dto.LoginDTO;
import com.javaguide.ISAprojekat.dto.UserRegistrationDTO;
import com.javaguide.ISAprojekat.dto.UserTokenState;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.model.User;
import com.javaguide.ISAprojekat.security.TokenUtils;
import com.javaguide.ISAprojekat.service.EmailSenderService;
import com.javaguide.ISAprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthentificationController {
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(consumes="application/json", value="/register/client")
    public ResponseEntity<HttpStatus> registerClient(@RequestBody UserRegistrationDTO data) {
        try {
            userService.saveClient(data);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value="/send-verification-mail/{email}")
    public ResponseEntity<HttpStatus> sendAccountConfirmationMail(@PathVariable String email) {
        try {
            emailSenderService.sendRegistrationEmail(email, "Confirmation mail",
                    "Click here to activate your account: http://localhost:8080/auth/confirm-mail/" + email
            );
        } catch(Exception ignored){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/confirm-mail/{email}")
    public ResponseEntity<HttpStatus> activateClientAccount(@PathVariable String email){
        Client client = userService.findByEmail(email);
        if (client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        client.setActive(true);
        userService.updateClient(client);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value="/register/{email}")
    public ResponseEntity<Client> emailExists(@PathVariable String email) {
        if (email == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        Client client = userService.findByEmail(email);
        if (client==null)
            return null;
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping(value="/login")
    public ResponseEntity<UserTokenState> login(@RequestBody LoginDTO loginData) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginData.getEmail(), loginData.getPassword()));
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();

        if(!user.isActive())
            return new ResponseEntity<>(null, HttpStatus.LOCKED);

        String userRole = user.getRole().getName().substring(5);
        String jwt = tokenUtils.generateToken(user.getEmail(), userRole);
        int expiresIn = tokenUtils.getExpiredIn();
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, userRole));
    }
    @GetMapping(value="/loggedInClient")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<Client> getLoggedInClient(HttpServletRequest request) {
        String email = tokenUtils.getEmailDirectlyFromHeader(request);
        if (email == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        Client client = userService.findByEmail(email);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
}
