package com.javaguide.ISAprojekat.dto;

import java.time.LocalDateTime;

public class AppointmentPresentationDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean taken;

    public AppointmentPresentationDTO(){

    }
    public AppointmentPresentationDTO(LocalDateTime startDate, LocalDateTime endDate,Boolean taken) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.taken=taken;
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


    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }
}
