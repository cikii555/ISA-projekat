package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.AppointmentDTO;
import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.security.TokenUtils;
import com.javaguide.ISAprojekat.service.AppointmentService;
import com.javaguide.ISAprojekat.service.EmailSenderService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final EmailSenderService emailSenderService;
    private final TokenUtils tokenUtils;
    public AppointmentController(AppointmentService _appointmentService,EmailSenderService _emailSenderService
                                ,TokenUtils _tokenUtils){
        appointmentService=_appointmentService;
        emailSenderService=_emailSenderService;
        tokenUtils=_tokenUtils;
    }
    @GetMapping(value="/sendemail/")
    public ResponseEntity<HttpStatus> SendEmail(HttpServletRequest request) {
        String email= tokenUtils.getEmailDirectlyFromHeader(request);
            if (email==null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        emailSenderService.sendEmail(email,"nesto","nesto");
        return new ResponseEntity<>(HttpStatus.OK);
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
