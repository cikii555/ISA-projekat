package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.AppointmentHistory;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.repository.AppointmentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentHistoryService {
    private final AppointmentHistoryRepository appointmentHistoryRepository;

    public AppointmentHistoryService(AppointmentHistoryRepository appointmentHistoryRepository) {
        this.appointmentHistoryRepository = appointmentHistoryRepository;
    }
    public void saveAppointmentHistory(Client client, Appointment appointment){
        AppointmentHistory aH = new AppointmentHistory(appointment, client, true, true);
        appointmentHistoryRepository.save(aH);

    }
}
