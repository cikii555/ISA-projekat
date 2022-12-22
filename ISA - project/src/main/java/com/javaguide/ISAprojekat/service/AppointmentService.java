package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.AppointmentDTO;
import com.javaguide.ISAprojekat.dto.CenterAppointmentDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.repository.AppointmentRepository;
import com.javaguide.ISAprojekat.repository.TransfusionCenterRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final TransfusionCenterRepository transfusionCenterRepository;

    public AppointmentService(AppointmentRepository _appointmentRepository, TransfusionCenterRepository transfusionCenterRepository){
        appointmentRepository=_appointmentRepository;
        this.transfusionCenterRepository = transfusionCenterRepository;

    }
    public void saveAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment(appointmentDTO);
        appointment.setBloodTransfusionCenter
                (transfusionCenterRepository.getBloodTransfusionCenterByName(appointmentDTO.getBloodTransfusionName()));
        appointmentRepository.save(appointment);
    }
    public List<CenterAppointmentDTO> getAllByCenter(BloodTransfusionCenter center){
        List<Appointment> all = appointmentRepository.findAll();
        List<CenterAppointmentDTO> centers = new ArrayList<>();
        for(Appointment a:all){
            if(a.getBloodTransfusionCenter().getId().equals(center.getId()) && a.getStartTime().isAfter(LocalDateTime.now()) && !a.isTaken())
                centers.add(new CenterAppointmentDTO(a.getStartTime(), a.getEndTime(), a.getId()));
        }
        return  centers;
    }

    public Appointment findById(Long appId) {
        return appointmentRepository.getAppointmentById(appId);
    }

    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
