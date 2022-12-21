package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.AppointmentHistoryDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.AppointmentHistory;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.repository.AppointmentHistoryRepository;
import com.javaguide.ISAprojekat.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentHistoryService {
    private final AppointmentHistoryRepository appointmentHistoryRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentHistoryService(AppointmentHistoryRepository appointmentHistoryRepository, AppointmentRepository appointmentRepository) {
        this.appointmentHistoryRepository = appointmentHistoryRepository;
        this.appointmentRepository = appointmentRepository;
    }
    public void saveAppointmentHistory(Client client, Appointment appointment){
        AppointmentHistory aH = new AppointmentHistory(appointment, client, true, true, false);
        appointmentHistoryRepository.save(aH);

    }
    public List<AppointmentHistoryDTO> getAllByClient(Integer clientId){
        ArrayList<AppointmentHistory> all = (ArrayList<AppointmentHistory>) appointmentHistoryRepository.findAll();
        ArrayList<AppointmentHistory> clients = new ArrayList<>();
        List<AppointmentHistoryDTO> dtos = new ArrayList<>();
        for(AppointmentHistory ah : all) {
            if (ah.getClient().getId().equals(clientId) && ah.getAppointment().getStartTime().isAfter(LocalDateTime.now()) && !ah.isCanceled())
                clients.add(ah);
        }
        for(AppointmentHistory ah:clients){
            AppointmentHistoryDTO dto = new AppointmentHistoryDTO(ah.getAppointment().getStartTime(),
                    ah.getAppointment().getEndTime(), ah.getAppointment().getBloodTransfusionCenter().getName(), ah.getAppointment().getId(), ah.getId());
            dtos.add(dto);
        }
        return dtos;
    }
    public void cancelAppointment(Long id){
        AppointmentHistory ah = appointmentHistoryRepository.getReferenceById(id);
        if(ah.getAppointment().getStartTime().isBefore(LocalDateTime.now().plusDays(1)))
            return;
        Appointment a = ah.getAppointment();
        a.setTaken(false);
        appointmentRepository.save(a);
        ah.setCanceled(true);
        appointmentHistoryRepository.save(ah);
    }
}
