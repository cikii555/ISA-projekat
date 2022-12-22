package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.MedicalStaff;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public class BloodDonationAppointmentDTO {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Set<MedicalStaff> medicalStaff;


    public BloodDonationAppointmentDTO(LocalDateTime startDateTime, LocalDateTime endDateTime, Set<MedicalStaff> medicalStaff) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.medicalStaff = medicalStaff;
    }

    public BloodDonationAppointmentDTO() {
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Set<MedicalStaff> getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(Set<MedicalStaff> medicalStaff) {
        this.medicalStaff = medicalStaff;
    }
}
