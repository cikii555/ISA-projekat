package com.javaguide.ISAprojekat.dto;

import java.time.LocalDateTime;

public class AppointmentHistoryDTO {
    private String startTime;
    private String endTime;
    private String bloodCenterName;
    private Long appointmentId;
    private Long historyId;

    public AppointmentHistoryDTO(LocalDateTime startTime, LocalDateTime endTime, String bloodCenterName, Long appointmentId, Long historyId) {
        this.startTime = startTime.toString();
        this.endTime = endTime.toString();
        this.bloodCenterName = bloodCenterName;
        this.appointmentId = appointmentId;
        this.historyId = historyId;
    }

    public String getBloodCenterName() {
        return bloodCenterName;
    }

    public void setBloodCenterName(String bloodCenterName) {
        this.bloodCenterName = bloodCenterName;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
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
}
