package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.Address;

public class ClientDTO {
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String jmbg;
    private String gender;
    private String occupation;
    private String organizationInformation;

    public ClientDTO() {
    }

    public ClientDTO(String password, String email, String firstName, String lastName, String phoneNumber, String jmbg, String gender, String occupation, String organizationInformation) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.jmbg = jmbg;
        this.gender = gender;
        this.occupation = occupation;
        this.organizationInformation = organizationInformation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOrganizationInformation() {
        return organizationInformation;
    }

    public void setOrganizationInformation(String organizationInformation) {
        this.organizationInformation = organizationInformation;
    }
}
