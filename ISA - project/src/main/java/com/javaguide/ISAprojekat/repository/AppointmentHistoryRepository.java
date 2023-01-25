package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.AppointmentHistory;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface AppointmentHistoryRepository extends JpaRepository<AppointmentHistory, Long> {

    @Query(value = "SELECT * FROM appointment_history ap inner join client c ON ap.client_id=c.id where LOWER(c.first_name) like LOWER(concat('%',:query,'%'))",nativeQuery = true)
    public ArrayList<AppointmentHistory> searchAppointmentHistoriesByClientName(String query);

    @Query(value = "SELECT * FROM appointment_history ap inner join client c ON ap.client_id=c.id where LOWER(c.last_Name) like LOWER(concat('%',:query,'%'))",nativeQuery = true)
    public ArrayList<AppointmentHistory> searchAppointmentHistoriesByClientSurname(String query);

    @Query(value="SELECT * FROM appointment_history ap inner join client c ON ap.client_id=c.id where LOWER(:firstName is null or c.first_name = :firstName)"
            +" and LOWER(:lastName is null or c.last_name = :lastName)",nativeQuery = true)
    ArrayList<AppointmentHistory> searchByFirstAndOrLastName(@Param("firstName") String firstName,
                                                  @Param("lastName") String lastName);


}
