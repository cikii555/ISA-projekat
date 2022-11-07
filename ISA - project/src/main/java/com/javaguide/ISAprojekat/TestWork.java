package com.javaguide.ISAprojekat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWork {
    @GetMapping("/welcome")
    public String Works(){
        return "Welcome to our app";
    }
}
