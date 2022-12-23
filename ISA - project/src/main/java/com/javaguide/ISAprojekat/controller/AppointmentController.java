package com.javaguide.ISAprojekat.controller;
import com.javaguide.ISAprojekat.dto.AppointmentDTO;
import com.javaguide.ISAprojekat.dto.AppointmentHistoryDTO;
import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping(value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private BloodTransfusionCenterService bloodTransfusionCenterService;
    @Autowired
    private SurveyService surveyService;
    private final UserService userService;
    private final AppointmentHistoryService appointmentHistoryService;
    private final AppointmentService appointmentService;
    private final EmailSenderService emailSenderService;
    @Autowired
    private TransfusionCenterService TransfusionCenterService;




    public AppointmentController(UserService userService, AppointmentHistoryService appointmentHistoryService
            ,EmailSenderService emailSenderService,AppointmentService appointmentService,BloodTransfusionCenterService bloodTransfusionCenterService
    ,TransfusionCenterService transfusionCenterService) {

        this.userService = userService;
        this.appointmentHistoryService = appointmentHistoryService;
        this.emailSenderService=emailSenderService;
        this.appointmentService = appointmentService;
        this.bloodTransfusionCenterService = bloodTransfusionCenterService;
        this.TransfusionCenterService = transfusionCenterService;
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
    @GetMapping(value="/getAllAppointments/{id}")
    public ResponseEntity<ArrayList<AppointmentPresentationDTO>> GetAllAppointments(@PathVariable int id) {
        System.out.println(id);
        try {
            ArrayList<AppointmentPresentationDTO> a=appointmentService.GetAllByCenter(id);
            return new ResponseEntity<>(a,HttpStatus.OK);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    @GetMapping(value="/getBanksForDate/{dateTime}")
        public ResponseEntity<ArrayList<TransfusionCenterDTO>> GetBanksForDate(@PathVariable String dateTime) {
        LocalDateTime dateTime1=LocalDateTime.parse(dateTime);
        dateTime1.plusSeconds(1);
        try {
            ArrayList<TransfusionCenterDTO> a=appointmentService.GetBloodBanksWithFreeSlots(dateTime1);
                return new ResponseEntity<>(a,HttpStatus.OK);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    @PostMapping(consumes="application/json", value="/addAppointmentHistory")
    public ResponseEntity<HttpStatus> addAppointmentHistory(@RequestBody AppointmentDTO appointment) {
        appointment.setEndDate(appointment.getStartDate().plusMinutes(appointment.getDuration()));
        System.out.println(appointment.getBloodTransfusionId());

        try {
            appointmentService.saveAppointment(appointment);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value="/scheduled/{centerId}")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<List<AppointmentHistoryDTO>> getScheduledAppointments(@PathVariable  Integer centerId){
    List<AppointmentHistoryDTO> newList = appointmentHistoryService.getAllByBloodTransfusionAppointment(centerId);

    return new ResponseEntity<>(newList,HttpStatus.OK);

    }

    @PostMapping(consumes = "application/json",value="/report")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<HttpStatus> addNewReport(@RequestBody Report report){

        Report newReport = new Report();
            newReport.setBloodType(report.getBloodType());
            newReport.setQuantity(report.getQuantity());
            List<BloodBank> bloodBankList = bloodTransfusionCenterService.getTransfusionCenterBloodBanks(1);
            for(BloodBank bb:bloodBankList){
                if(bb.getBloodType()==report.getBloodType()){
                    bb.setQuantity(bb.getQuantity()+report.getQuantity());
                }
            }
        List<Equipment> equipmentList = bloodTransfusionCenterService.getTransfusionCenterEquipment(1);
            List<Equipment> usedEquipment = new ArrayList<>(report.getUsedEquipment());
            for(Equipment equipment:equipmentList){
                for(Equipment userq:usedEquipment){
                    if(equipment.getId() == userq.getId()){
                        equipment.setQuantity(equipment.getQuantity()- userq.getQuantity());
                    }
                }

            }
            return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping(value="/search/firstname={name}")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<List<AppointmentHistoryDTO>> searchAppointmentsByClientName(@PathVariable String name){
        return new ResponseEntity<>(appointmentHistoryService.searchByNameAppointmentHistory(name),HttpStatus.OK);
    }
    @GetMapping(value="/search/lastname={name}")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<List<AppointmentHistoryDTO>> searchAppointmentsByClientSurname(@PathVariable String name) {
        return new ResponseEntity<>(appointmentHistoryService.searchBySurnameAppointmentHistory(name), HttpStatus.OK);
    }

    @GetMapping(consumes="application/json", value="/center/{center}")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<List<CenterAppointmentDTO>> getAppointmentsByCenter(@PathVariable String center) {
        BloodTransfusionCenter centerT = TransfusionCenterService.getByName(center);
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
