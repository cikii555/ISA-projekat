package com.javaguide.ISAprojekat.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String bloodTransfusionName;


    public AppointmentDTO(){

    }

    public AppointmentDTO(LocalDateTime startDate, LocalDateTime endDate, String bloodTransfusionCenter) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.bloodTransfusionName = bloodTransfusionCenter;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getBloodTransfusionName() {
        return bloodTransfusionName;
    }

    public void setBloodTransfusionName(String bloodTransfusionName) {
        this.bloodTransfusionName = bloodTransfusionName;
    }
}
