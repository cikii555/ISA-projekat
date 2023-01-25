package com.javaguide.ISAprojekat.dto;

import java.time.LocalDateTime;

public class AppointmentPresentationDTO {
    private String startDate;
    private String endDate;
    private Boolean taken;

    public AppointmentPresentationDTO(){

    }
    public AppointmentPresentationDTO(LocalDateTime startDate, LocalDateTime endDate,Boolean taken) {
        this.startDate = startDate.toString();
        this.endDate = endDate.toString();
        this.taken=taken;
    }

    public String  getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate.toString();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate.toString();
    }


    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }
}
