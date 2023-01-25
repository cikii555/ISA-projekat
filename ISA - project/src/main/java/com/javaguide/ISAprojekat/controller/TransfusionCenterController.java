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

@RestController
@RequestMapping(value = "/center", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransfusionCenterController {
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private TransfusionCenterService transfusionCenterService;
    @Autowired
    private UserService userService;
    @Autowired
    private AppointmentHistoryService appointmentHistoryService;

    @GetMapping()
    public ResponseEntity<List<TransfusionCenterDTO>> all() {
        return new ResponseEntity<List<TransfusionCenterDTO>>(transfusionCenterService.getAll(), HttpStatus.OK);
    }

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
