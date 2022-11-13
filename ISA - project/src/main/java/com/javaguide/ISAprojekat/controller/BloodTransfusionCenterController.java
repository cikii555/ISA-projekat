package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.AddressDTO;
import com.javaguide.ISAprojekat.dto.BloodTransfusionCenterDTO;
import com.javaguide.ISAprojekat.dto.CenterAdminDTO;
import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.Address;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.service.AddressService;
import com.javaguide.ISAprojekat.service.AppointmentHistoryService;
import com.javaguide.ISAprojekat.service.BloodTransfusionCenterService;
import com.javaguide.ISAprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/bloodtransfusioncenter")
public class BloodTransfusionCenterController {

    @Autowired
    private BloodTransfusionCenterService bloodTransfusionCenterService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AppointmentHistoryService appointmentHistoryService;
    @Autowired
    private UserService userService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<BloodTransfusionCenterDTO> getBloodCenter(@PathVariable Integer id) {

        BloodTransfusionCenter center = bloodTransfusionCenterService.findOne(id);

        // studen must exist
        if (center == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new BloodTransfusionCenterDTO(center), HttpStatus.OK);
    }
    @GetMapping(value="/address/{id}")
    public ResponseEntity<AddressDTO> getAdressCenter(@PathVariable String id){
        Integer id1 = Integer.parseInt(id);
        Address address = addressService.findOne(id1);
        if(address == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new AddressDTO(address),HttpStatus.OK);
    }

   /* @GetMapping(value="/admins/{id}")
    public ResponseEntity<List<CenterAdminDTO>> getOtherCenterAdmins(@PathVariable Integer id){
        //traze se polozeni ispiti studenta, sto znaci da moramo uputiti JOIN FETCH upit
        //kako bismo dobili sve trazene podatke
        BloodTransfusionCenter center = bloodTransfusionCenterService.findOneWithAdmins(id);

        //ako je podesen fetchType LAZY i pozovemo findOne umesto findOneWithExams,
        //na poziv getExams bismo dobili LazyInitializationException
        /*Set<Exam> exams = student.getExams();
        List<ExamDTO> examsDTO = new ArrayList<>();
        for (Exam e : exams) {
            ExamDTO examDTO = new ExamDTO();
            examDTO.setId(e.getId());
            examDTO.setGrade(e.getGrade());
            examDTO.setDate(e.getDate());
            examDTO.setCourse(new CourseDTO(e.getCourse()));
            examDTO.setStudent(new StudentDTO(e.getStudent()));

            examsDTO.add(examDTO);
        }
        return new ResponseEntity<>(examsDTO, HttpStatus.OK);*/
   // }

    @PutMapping(path = "/update",consumes = "application/json")
    public ResponseEntity<BloodTransfusionCenterDTO> updateCenter(@RequestBody BloodTransfusionCenterDTO centerDTO) {

        // a student must exist
        BloodTransfusionCenter center = bloodTransfusionCenterService.findOne(centerDTO.getId());

        if (center == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }



        center = bloodTransfusionCenterService.save(center);
        return new ResponseEntity<>(new BloodTransfusionCenterDTO(center), HttpStatus.OK);
    }
}
