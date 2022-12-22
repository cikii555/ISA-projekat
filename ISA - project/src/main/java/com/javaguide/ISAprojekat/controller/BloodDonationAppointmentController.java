package com.javaguide.ISAprojekat.controller;


import com.javaguide.ISAprojekat.dto.AppointmentHistoryDTO;
import com.javaguide.ISAprojekat.dto.BloodDonationAppointmentDTO;
import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.service.BloodDonationAppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/appointment",produces = MediaType.APPLICATION_JSON_VALUE)
public class BloodDonationAppointmentController {

    private final BloodDonationAppointmentService bloodDonationAppointmentService;


    public BloodDonationAppointmentController(BloodDonationAppointmentService bloodDonationAppointmentService) {
        this.bloodDonationAppointmentService = bloodDonationAppointmentService;
    }

    @PostMapping( value="/add")
    public ResponseEntity<BloodDonationAppointmentDTO> saveAppointment(@RequestBody BloodDonationAppointmentDTO bloodDonationAppointmentDTO) {
        System.out.println(bloodDonationAppointmentDTO.getEndDateTime()+"caooooooooooo");
        System.out.println(bloodDonationAppointmentDTO.getMedicalStaff().size()+"ahhahahah");
        Appointment bloodDonationApp = new Appointment();
        bloodDonationApp.setStartTime(bloodDonationAppointmentDTO.getStartDateTime());
        bloodDonationApp.setEndTime(bloodDonationAppointmentDTO.getEndDateTime());
        bloodDonationApp.setTaken(false);
        //new StudentDTO(student),
        //bloodDonationApp = bloodDonationAppointmentService.saveAppointment(bloodDonationApp);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }



}
