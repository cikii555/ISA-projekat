package com.javaguide.ISAprojekat.controller;
import com.javaguide.ISAprojekat.dto.*;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.AppointmentHistory;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.security.TokenUtils;
import com.javaguide.ISAprojekat.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private TransfusionCenterService bloodTransfusionCenterService;
    @Autowired
    private SurveyService surveyService;
    private final UserService userService;
    private final AppointmentHistoryService appointmentHistoryService;
    private final AppointmentService appointmentService;
    private final EmailSenderService emailSenderService;


    public AppointmentController(UserService userService, AppointmentHistoryService appointmentHistoryService
                                ,EmailSenderService emailSenderService,AppointmentService appointmentService) {
        this.appointmentService=appointmentService;
        this.userService = userService;
        this.appointmentHistoryService = appointmentHistoryService;
        this.emailSenderService=emailSenderService;
    }
    @GetMapping()
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<List<AppointmentHistoryDTO>> all(HttpServletRequest request) {
        String email = tokenUtils.getEmailDirectlyFromHeader(request);
        if (email == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        Client client = userService.findByEmail(email);
        return new ResponseEntity<List<AppointmentHistoryDTO>>(appointmentHistoryService.getAllByClient(client.getId()), HttpStatus.OK);
    }
    @PatchMapping(value="/cancel/{id}")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<HttpStatus> cancelAppointment(@PathVariable Long id, HttpServletRequest request) {
        appointmentHistoryService.cancelAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
    @GetMapping(consumes="application/json", value="/center/{center}")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<List<CenterAppointmentDTO>> getAppointmentsByCenter(@PathVariable String center) {
        BloodTransfusionCenter centerT = bloodTransfusionCenterService.getByName(center);
        return new ResponseEntity<List<CenterAppointmentDTO>>(appointmentService.getAllByCenter(centerT), HttpStatus.OK);
    }
    @GetMapping(consumes="application/json", value="/canDonate")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<Boolean> canClientDonate(HttpServletRequest request) {
        String email = tokenUtils.getEmailDirectlyFromHeader(request);
        if (email == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        Client client = userService.findByEmail(email);
        Boolean filledOutSurvey = surveyService.canDonate(client);
        Boolean didntDonate = appointmentHistoryService.canDonate(client);
        return new ResponseEntity<Boolean>((filledOutSurvey && didntDonate), HttpStatus.OK);
    }

    @PostMapping(consumes="application/json", value="/schedule/{appId}")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<HttpStatus> scheduleAppointment(@PathVariable Long appId, HttpServletRequest request) {
        String email = tokenUtils.getEmailDirectlyFromHeader(request);
        if (email == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        Client client = userService.findByEmail(email);
        Appointment appointment = appointmentService.findById(appId);
        appointment.setTaken(true);
        appointmentService.updateAppointment(appointment);
        AppointmentHistory ah = new AppointmentHistory(appointment, client, false, true, false);
        appointmentHistoryService.saveAppointmentHistory(ah);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
