package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.AppointmentHistoryDTO;
import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.AppointmentHistory;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.security.TokenUtils;
import com.javaguide.ISAprojekat.service.AppointmentHistoryService;
import com.javaguide.ISAprojekat.service.TransfusionCenterService;
import com.javaguide.ISAprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {
    @Autowired
    private TokenUtils tokenUtils;
    private final UserService userService;
    private final AppointmentHistoryService appointmentHistoryService;

    public AppointmentController(UserService userService, AppointmentHistoryService appointmentHistoryService) {
        this.userService = userService;
        this.appointmentHistoryService = appointmentHistoryService;
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
}
