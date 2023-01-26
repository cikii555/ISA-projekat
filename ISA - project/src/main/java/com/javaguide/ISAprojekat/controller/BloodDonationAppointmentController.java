package com.javaguide.ISAprojekat.controller;


import com.javaguide.ISAprojekat.dto.BloodDonationAppointmentDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.service.BloodDonationAppointmentService;
import com.javaguide.ISAprojekat.service.BloodTransfusionCenterService;
import com.javaguide.ISAprojekat.service.TransfusionCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/appointment",produces = MediaType.APPLICATION_JSON_VALUE)
public class BloodDonationAppointmentController {

    private final BloodDonationAppointmentService bloodDonationAppointmentService;
    private final BloodTransfusionCenterService bloodTransfusionCenterService;


    public BloodDonationAppointmentController(BloodDonationAppointmentService bloodDonationAppointmentService, TransfusionCenterService transfusionCenterService, BloodTransfusionCenterService bloodTransfusionCenterService) {
        this.bloodDonationAppointmentService = bloodDonationAppointmentService;
        this.bloodTransfusionCenterService = bloodTransfusionCenterService;

    }

    @PostMapping( value="/add")
    public ResponseEntity<BloodDonationAppointmentDTO> saveAppointment(@RequestBody BloodDonationAppointmentDTO bloodDonationAppointmentDTO) {
        System.out.println(bloodDonationAppointmentDTO.getEndDateTime()+"caooooooooooo");
        System.out.println(bloodDonationAppointmentDTO.getMedicalStaff().size()+"ahhahahah");
        Appointment bloodDonationApp = new Appointment();
        BloodTransfusionCenter center = bloodTransfusionCenterService.findOne(bloodDonationAppointmentDTO.getBloodTransfusionCenterId());
        bloodDonationApp.setStartTime(bloodDonationAppointmentDTO.getStartDateTime());
        bloodDonationApp.setEndTime(bloodDonationAppointmentDTO.getEndDateTime());
        bloodDonationApp.setTaken(false);
        bloodDonationApp.setBloodTransfusionCenter(center);
        bloodDonationApp.setMedicalStaff(bloodDonationAppointmentDTO.getMedicalStaff());
        //new StudentDTO(student),
        bloodDonationApp = bloodDonationAppointmentService.saveAppointment(bloodDonationApp);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }



}
