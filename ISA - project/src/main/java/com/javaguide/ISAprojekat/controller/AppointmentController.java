package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.AppointmentDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService _appointmentService){
        appointmentService=_appointmentService;
    }
    @PostMapping(consumes="application/json", value="/addAppointmentHistory")
    public ResponseEntity<HttpStatus> addAppointmentHistory(@RequestBody AppointmentDTO appointment) {
        System.out.println("u funkciji smo???");
        System.out.println(appointment.getBloodTransfusionName());

        try {
            appointmentService.saveAppointment(appointment);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
