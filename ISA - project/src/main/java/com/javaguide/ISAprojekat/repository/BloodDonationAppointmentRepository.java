package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodDonationAppointmentRepository extends JpaRepository<Appointment,Long> {



}
