package com.javaguide.ISAprojekat.model;

import com.javaguide.ISAprojekat.dto.UserRegistrationDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Client extends User{
    public Client() {
    }
    public Client(UserRegistrationDTO userRegistrationDTO) {
        this.setFirstName(userRegistrationDTO.getFirstName());
        this.setLastName(userRegistrationDTO.getLastName());
        this.setEmail(userRegistrationDTO.getEmail());
        this.setJmbg(userRegistrationDTO.getJmbg());
        this.setGender(userRegistrationDTO.getGender());
        this.setOccupation(userRegistrationDTO.getOccupation());
        this.setOrganizationInformation(userRegistrationDTO.getOrganizationInformation());
        this.setAddress(new Address(userRegistrationDTO.getCountry(), userRegistrationDTO.getCity(), userRegistrationDTO.getStreet(), userRegistrationDTO.getStreetNumber()));
        this.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
        this.setPassword(new BCryptPasswordEncoder().encode(userRegistrationDTO.getPassword()));
//        this.setPassword(userRegistrationDTO.getPassword());
        this.setRole(new Role("ROLE_CLIENT"));
        this.setActive(false);
    }
}
