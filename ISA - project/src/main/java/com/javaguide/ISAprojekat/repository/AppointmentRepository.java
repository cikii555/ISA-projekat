package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.AppointmentHistory;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query(value = "SELECT * FROM appointment app where app.blood_transfusion_center_id=:centerId",nativeQuery = true)
    public ArrayList<Appointment> GetAllByCenter(Integer centerId);

}
