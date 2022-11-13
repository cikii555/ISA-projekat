package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.AppointmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentHistoryRepository extends JpaRepository<AppointmentHistory, Long> {
}
