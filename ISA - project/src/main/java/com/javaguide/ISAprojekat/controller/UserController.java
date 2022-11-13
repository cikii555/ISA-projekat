package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.model.User;
import com.javaguide.ISAprojekat.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//"origins = http://localhost:4200"
@CrossOrigin( "*")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userByName/{firstName}")
    public List<User> getUserByFirstName(@PathVariable String firstName){
        return userService.findUserByFirstName(firstName);
    }
    @GetMapping("/userBySurname/{lastName}")
    public List<User> getUserByLastName(@PathVariable String lastName){
        return userService.findUserByLastName(lastName);
    }
    @PostMapping("/registerSystemAdmin")
    public ResponseEntity<User> registerSystemAdmin(@RequestBody User user){
        return new ResponseEntity<User>(userService.insertSystemAdmin(user), HttpStatus.OK);
    }
    @PostMapping("/registerCenterAdmin")
    public ResponseEntity<User> registerCenterAdmin(@RequestBody User user){
        return new ResponseEntity<User>(userService.insertCenterAdmin(user), HttpStatus.OK);
    }
}
