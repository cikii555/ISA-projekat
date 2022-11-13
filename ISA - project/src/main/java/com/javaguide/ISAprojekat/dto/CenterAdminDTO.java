package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.Address;
import com.javaguide.ISAprojekat.model.MedicalStaff;

public class CenterAdminDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private Address address;
    private String password;
    public CenterAdminDTO(Integer id,String firstName, String lastName, String username, String email, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = id;
    }



    public CenterAdminDTO(MedicalStaff centeradmin) {
        this(centeradmin.getId(),centeradmin.getFirstName(), centeradmin.getLastName(),centeradmin.getUsername(),centeradmin.getEmail(),centeradmin.getPhoneNumber(),centeradmin.getAddress());
    }

    public CenterAdminDTO() {

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
