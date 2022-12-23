package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.Appointment;

import com.javaguide.ISAprojekat.model.AppointmentHistory;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;


import java.util.ArrayList;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment getAppointmentById(Long id);
    @Query(value = "SELECT * FROM appointment app where app.blood_transfusion_center_id=:centerId order by app.start_time ASC",nativeQuery = true)
    public ArrayList<Appointment> GetAllByCenter(Integer centerId);

    @Query(value = "SELECT distinct app.blood_transfusion_center_id FROM appointment app where taken=false and :dateTime between app.start_time and app.end_time",nativeQuery = true)
    public ArrayList<Long> GetBloodBanksWithFreeSlots(LocalDateTime dateTime);

    @Query(value = "SELECT id FROM appointment app where taken=false and app.blood_transfusion_center_id=:centerID and :dateTime between app.start_time and app.end_time",nativeQuery = true)
    public Long GetByTime(LocalDateTime dateTime,Integer centerID);
}
