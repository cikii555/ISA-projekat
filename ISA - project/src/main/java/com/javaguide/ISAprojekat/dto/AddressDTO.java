package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.Address;

public class AddressDTO {
    private String country;
    private String number;
    private String city;
    private String street;

    public AddressDTO(String country, String number, String city, String street) {
        this.country = country;
        this.number = number;
        this.city = city;
        this.street = street;
    }

    public AddressDTO(Address address) {
        this(address.getCountry(),address.getStreetNumber(), address.getCity(), address.getStreet());
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
