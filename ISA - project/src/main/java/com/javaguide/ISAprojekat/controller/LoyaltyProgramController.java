package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.model.LoyaltyProgram;
import com.javaguide.ISAprojekat.service.LoyaltyProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( "*")
@RestController
@RequestMapping(value = "/loyalty", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoyaltyProgramController {

    private final LoyaltyProgramService loyaltyProgramService;

    public LoyaltyProgramController(LoyaltyProgramService loyaltyProgramService) {
        this.loyaltyProgramService = loyaltyProgramService;
    }


    @PostMapping("/registerLoyalty")
    public ResponseEntity<LoyaltyProgram> registerLoyaltyProgram(@RequestBody LoyaltyProgram loyaltyProgram){
        return new ResponseEntity<LoyaltyProgram>(loyaltyProgramService.insertLoyaltyProgram(loyaltyProgram), HttpStatus.OK);
    }
}
