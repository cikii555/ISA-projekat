package com.javaguide.ISAprojekat.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long bloodTransfusionId;


    public AppointmentDTO(){

    }

    public AppointmentDTO(LocalDateTime startDate, LocalDateTime endDate, Long bloodTransfusionCenter) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.bloodTransfusionId = bloodTransfusionCenter;
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

    public Long getBloodTransfusionId() {
        return bloodTransfusionId;
    }

    public void setBloodTransfusionName(Long bloodTransfusionId) {
        this.bloodTransfusionId = bloodTransfusionId;
    }
}
