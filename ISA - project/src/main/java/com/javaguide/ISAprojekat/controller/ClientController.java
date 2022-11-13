package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.CenterAdminDTO;
import com.javaguide.ISAprojekat.dto.ClientDTO;
import com.javaguide.ISAprojekat.dto.UserRegistrationDTO;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.model.MedicalStaff;
import com.javaguide.ISAprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping(value="/clients")
public class ClientController {
    private UserService userService;


    @Autowired
    ClientController( UserService _userService){
        this.userService=_userService;
    }

    @PutMapping( path="/update",consumes = "application/json")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO){
        Client client = userService.findByEmail(clientDTO.getEmail());

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setJmbg(clientDTO.getJmbg());
        client.setGender(clientDTO.getGender());
        client.setOccupation(clientDTO.getOccupation());
        client.setOrganizationInformation(clientDTO.getOrganizationInformation());


        userService.updateClient(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
