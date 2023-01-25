package com.javaguide.ISAprojekat.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long bloodTransfusionId;
    private int duration;

    public AppointmentDTO(){

    }
    public AppointmentDTO(LocalDateTime startDate, int duration, Long bloodTransfusionCenter) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration=duration;
        this.bloodTransfusionId = bloodTransfusionCenter;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void getBloodTransfusionId(Long bloodTransfusionId) {
        this.bloodTransfusionId = bloodTransfusionId;
    }
}
