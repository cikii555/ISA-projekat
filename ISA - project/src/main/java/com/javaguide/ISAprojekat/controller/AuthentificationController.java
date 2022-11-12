package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.UserRegistrationDTO;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.security.TokenUtils;
import com.javaguide.ISAprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthentificationController {
    private TokenUtils tokenUtils;

    private UserService userService;

    private AuthenticationManager authenticationManager;


    @Autowired
    public AuthentificationController(TokenUtils tokenUtils, UserService userService,
                                      AuthenticationManager authenticationManager) {
        super();
        this.tokenUtils = tokenUtils;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping(consumes="application/json", value="/register/client")
    public ResponseEntity<HttpStatus> registerClient(@RequestBody UserRegistrationDTO data) {
//        if (!data.arePropsValid())
//            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
//
//        if (userService.findByEmail(data.getEmail()) != null)
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        try {
            userService.saveClient(data);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(consumes="application/json", value="/register/{email}")
    public ResponseEntity<Client> emailExists(@PathVariable String email) {
//        String email = tokenUtils.getEmailDirectlyFromHeader(request);
        if (email == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        Client client = userService.findByEmail(email);
        if (client==null)
            return null;
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

//    @PostMapping(value="/login")
//    @CrossOrigin(origins = ServerConfig.FRONTEND_ORIGIN)
//    public ResponseEntity<UserTokenDTO> login(@RequestBody LoginDTO loginData) {
//        Authentication authentication;
//        try {
//            authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginData.getEmail(), loginData.getPassword()
//                    )
//            );
//        } catch (Exception ignored) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        User user = (User) authentication.getPrincipal();
//
//        if(!user.isActive() || user.isDeleted())
//            return new ResponseEntity<>(null, HttpStatus.LOCKED);
//
//        String userRole = user.getRole().getName().substring(5);
//        return new ResponseEntity<>(
//                new UserTokenDTO(
//                        tokenUtils.generateToken(user.getEmail(), userRole),
//                        tokenUtils.getExpiredIn(),
//                        userRole
//                ),
//                HttpStatus.OK
//        );
//    }
}
