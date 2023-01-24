package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.AppointmentHistoryDTO;
import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
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
    public void saveAppointmentHistory(AppointmentHistory appointmentHistory){
        appointmentHistoryRepository.save(appointmentHistory);
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
    public List<AppointmentHistoryDTO> getAllHistoriesByClient(Integer clientId){
        ArrayList<AppointmentHistory> all = (ArrayList<AppointmentHistory>) appointmentHistoryRepository.findAll();
        ArrayList<AppointmentHistory> clients = new ArrayList<>();
        List<AppointmentHistoryDTO> dtos = new ArrayList<>();
        for(AppointmentHistory ah : all) {
            if (ah.getClient().getId().equals(clientId) && ah.isShowedUp())
                clients.add(ah);
        }
        for(AppointmentHistory ah:clients){
            AppointmentHistoryDTO dto = new AppointmentHistoryDTO(ah.getAppointment().getStartTime(),
                    ah.getAppointment().getEndTime(), ah.getAppointment().getBloodTransfusionCenter().getName(), ah.getAppointment().getId(), ah.getId());
            dtos.add(dto);
        }
        return dtos;
    }
    public List<AppointmentHistoryDTO> getAllByBloodTransfusionAppointment(Integer centerId){
        ArrayList<AppointmentHistory> all = (ArrayList<AppointmentHistory>) appointmentHistoryRepository.findAll();
        ArrayList<AppointmentHistory> appointmentHistories = new ArrayList<>();
        List<AppointmentHistoryDTO> dtos = new ArrayList<>();
        for(AppointmentHistory ah : all) {
            if (ah.getAppointment().getId().equals(centerId) && ah.getAppointment().getStartTime().isAfter(LocalDateTime.now()) )
                appointmentHistories.add(ah);
        }
        for(AppointmentHistory ah:appointmentHistories){
            AppointmentHistoryDTO appointmentHistoryDTO = new AppointmentHistoryDTO(ah.getAppointment().getStartTime(),
                    ah.getAppointment().getEndTime(), ah.getAppointment().getBloodTransfusionCenter().getName(), ah.getAppointment().getId(), ah.getClient().getFirstName(),
                    ah.getClient().getLastName(),ah.getClient().getId(),ah.getId());
            dtos.add(appointmentHistoryDTO);
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



    public List<AppointmentHistoryDTO> searchBySurnameAppointmentHistory(String query) {

        List<AppointmentHistory> appointmentHistories=  appointmentHistoryRepository.searchAppointmentHistoriesByClientSurname(query);
        List<AppointmentHistoryDTO> dtos = new ArrayList<>();

        for(AppointmentHistory ah:appointmentHistories){
            AppointmentHistoryDTO appointmentHistoryDTO = new AppointmentHistoryDTO(ah.getAppointment().getStartTime(),  ah.getAppointment().getEndTime(), ah.getAppointment().getBloodTransfusionCenter().getName(), ah.getId(), ah.getClient().getFirstName(), ah.getClient().getLastName(),ah.getClient().getId(),ah.getId());
            dtos.add(appointmentHistoryDTO);
        }
        return dtos;

    }

    public List<AppointmentHistoryDTO> searchByNameAppointmentHistory(String query) {
        List<AppointmentHistory> appointmentHistories=  appointmentHistoryRepository.searchAppointmentHistoriesByClientName(query);
        List<AppointmentHistoryDTO> dtos = new ArrayList<>();

        for(AppointmentHistory ah:appointmentHistories){
            AppointmentHistoryDTO appointmentHistoryDTO = new AppointmentHistoryDTO(ah.getAppointment().getStartTime(),
                    ah.getAppointment().getEndTime(), ah.getAppointment().getBloodTransfusionCenter().getName(), ah.getAppointment().getId(), ah.getClient().getFirstName(),
                    ah.getClient().getLastName(),ah.getClient().getId(),ah.getId());
            dtos.add(appointmentHistoryDTO);
        }
        return dtos;
    }

    public List<AppointmentHistoryDTO> searchByFirstNameAndLastNameAppointmentHistory(String firstName, String lastName){
        List<AppointmentHistory> appointmentHistories = appointmentHistoryRepository.searchByFirstAndOrLastName(firstName,lastName);
        List<AppointmentHistoryDTO> dtos = new ArrayList<>();
        for(AppointmentHistory ah:appointmentHistories){
            AppointmentHistoryDTO appointmentHistoryDTO = new AppointmentHistoryDTO(ah.getAppointment().getStartTime(),  ah.getAppointment().getEndTime(), ah.getAppointment().getBloodTransfusionCenter().getName(), ah.getAppointment().getId(), ah.getClient().getFirstName(), ah.getClient().getLastName(),ah.getClient().getId(),ah.getId());
            dtos.add(appointmentHistoryDTO);
        }
        return dtos;
    }

    public AppointmentHistory findOne(Long appHistoryId) {
        return appointmentHistoryRepository.findById(appHistoryId).orElseGet(null);
    }
    public Boolean canDonate(Client client) {
        ArrayList<AppointmentHistory> all = (ArrayList<AppointmentHistory>) appointmentHistoryRepository.findAll();
        ArrayList<AppointmentHistory> clients = new ArrayList<>();
        for(AppointmentHistory ah : all) {
            if (ah.getClient().getId().equals(client.getId()) && ah.getAppointment().getStartTime().isAfter(LocalDateTime.now()) && !ah.isCanceled())
                clients.add(ah);
        }
        for(AppointmentHistory ch:clients){
            if(ch.isShowedUp() && ch.getAppointment().getStartTime().isAfter(LocalDateTime.now().minusMonths(6)))
                return false;
        }
        return true;

    }
}
