package com.javaguide.ISAprojekat.dto;

import java.time.LocalDateTime;

public class CenterAppointmentDTO {
    private String startTime;
    private String endTime;
    private Long id;

    public CenterAppointmentDTO() {
    }

    public CenterAppointmentDTO(LocalDateTime startTime, LocalDateTime endTime, Long id) {
        this.startTime = startTime.toString();
        this.endTime = endTime.toString();
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
