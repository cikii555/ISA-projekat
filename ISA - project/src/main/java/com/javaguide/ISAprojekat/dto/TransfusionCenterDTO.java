package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.WorkHours;

import java.time.LocalTime;

public class TransfusionCenterDTO {
    public String name;
    public String country;
    public String city;
    public String street;
    public String streetNumber;
    public String description;
    public double averageGrade;
    public String startTime;
    public String endTime;

    public TransfusionCenterDTO() {
    }

    public TransfusionCenterDTO(String name, String country, String city, String street, String streetNumber, String description, double averageGrade, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.description = description;
        this.averageGrade = averageGrade;
        this.startTime = startTime.toString();
        this.endTime = endTime.toString();
    }
}
