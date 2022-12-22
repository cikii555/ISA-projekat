package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.model.Survey;
import com.javaguide.ISAprojekat.security.TokenUtils;
import com.javaguide.ISAprojekat.service.AppointmentHistoryService;
import com.javaguide.ISAprojekat.service.SurveyService;
import com.javaguide.ISAprojekat.service.TransfusionCenterService;
import com.javaguide.ISAprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/center", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransfusionCenterController {
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private SurveyService surveyService;
    private final TransfusionCenterService transfusionCenterService;
    private final UserService userService;
    private final AppointmentHistoryService appointmentHistoryService;

    public TransfusionCenterController(TransfusionCenterService transfusionCenterService, UserService userService, AppointmentHistoryService appointmentHistoryService) {
        this.transfusionCenterService = transfusionCenterService;
        this.userService = userService;
        this.appointmentHistoryService = appointmentHistoryService;
    }
    @GetMapping()
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<List<TransfusionCenterDTO>> all() {
        return new ResponseEntity<List<TransfusionCenterDTO>>(transfusionCenterService.getAll(), HttpStatus.OK);
    }
//    @PostMapping(consumes="application/json", value="/addAppointmentHistory/{center}")
//    @PreAuthorize("hasRole('CLIENT')")
//    public ResponseEntity<HttpStatus> addAppointmentHistory(@PathVariable String center) {
//        BloodTransfusionCenter centerT = transfusionCenterService.getByName(center);
//        Client client = userService.findByEmail("client@gmail.com");
//        Appointment appointment = new Appointment();
//        appointment.setStartTime(LocalDateTime.now());
//        appointment.setEndTime(LocalDateTime.now().plusHours(1));
//        appointment.setTaken(true);
//        appointment.setBloodTransfusionCenter(centerT);
//        try {
//            appointmentHistoryService.saveAppointmentHistory(client, appointment);
//        } catch (Exception ignored) {
//            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
@PostMapping(consumes="application/json", value="/addSurvey")
@PreAuthorize("hasRole('CLIENT')")
public ResponseEntity<HttpStatus> addSurvey(HttpServletRequest request) {
    String email = tokenUtils.getEmailDirectlyFromHeader(request);
    if (email == null)
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

    Client client = userService.findByEmail(email);
    LocalDate taken = LocalDate.now();
    Survey survey = new Survey(client, taken);
    try {
        surveyService.saveSurvey(survey);
    } catch (Exception ignored) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    return new ResponseEntity<>(HttpStatus.OK);
}
}
