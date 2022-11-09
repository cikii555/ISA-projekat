package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.Address;
import com.javaguide.ISAprojekat.utils.Validation;

public class UserRegistrationDTO {
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String country;
    private String city;
    private String street;
    private String streetNumber;
    private String jmbg;
    private String gender;
    private String occupation;
    private String organizationInformation;

    public UserRegistrationDTO(String password, String email, String firstName, String lastName, String phoneNumber, String country, String city, String street, String streetNumber, String jmbg, String gender, String occupation, String organizationInformation) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.jmbg = jmbg;
        this.gender = gender;
        this.occupation = occupation;
        this.organizationInformation = organizationInformation;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getOrganizationInformation() {
        return organizationInformation;
    }
    public boolean arePropsValid() {
        return Validation.validatePassword(this.password) &&
                Validation.validateName(this.firstName) &&
                Validation.validateName(this.lastName) &&
                Validation.validateWords(this.country) &&
                Validation.validateWords(this.city) &&
                Validation.validateStreet(this.street) &&
                Validation.validateStreet(this.streetNumber)&&
                Validation.validateNumber(this.phoneNumber) &&
                Validation.validateEmail(this.email);
    }
}
