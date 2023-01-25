package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.AppointmentHistory;

import java.time.LocalDateTime;

public class AppointmentHistoryDTO {
    private String startTime;
    private String endTime;
    private String bloodCenterName;
    private Long appointmentId;
    private Long historyId;

    private String patientName;

    private String patientSurname;

    private Integer clientId;
    public AppointmentHistoryDTO(LocalDateTime startTime, LocalDateTime endTime, String bloodCenterName, Long appointmentId, Long historyId) {
        this.startTime = startTime.toString();
        this.endTime = endTime.toString();
        this.bloodCenterName = bloodCenterName;
        this.appointmentId = appointmentId;
        this.historyId = historyId;
    }

    public AppointmentHistoryDTO(LocalDateTime startTime, LocalDateTime endTime, String bloodCenterName,
                                 Long appointmentId, String patientName, String patientSurname,
                                 Integer id,Long ahId) {
        this.startTime = startTime.toString();
        this.endTime = endTime.toString();
        this.bloodCenterName = bloodCenterName;
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.clientId = id;
        this.historyId = ahId;
    }
    public AppointmentHistoryDTO(AppointmentHistory appointmentHistory){
        this(appointmentHistory.getAppointment().getStartTime(), appointmentHistory.getAppointment().getEndTime(),
                appointmentHistory.getAppointment().getBloodTransfusionCenter().getName(),
                appointmentHistory.getAppointment().getId(),appointmentHistory.getClient().getFirstName(),
                appointmentHistory.getClient().getLastName(),appointmentHistory.getClient().getId(),
                appointmentHistory.getId());
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
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
