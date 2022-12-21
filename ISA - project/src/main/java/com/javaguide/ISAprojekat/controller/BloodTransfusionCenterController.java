package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.*;
import com.javaguide.ISAprojekat.model.*;
import com.javaguide.ISAprojekat.service.AddressService;
import com.javaguide.ISAprojekat.service.AppointmentHistoryService;
import com.javaguide.ISAprojekat.service.BloodTransfusionCenterService;
import com.javaguide.ISAprojekat.service.MedicalStaffService;
import com.javaguide.ISAprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/bloodtransfusioncenter",produces = MediaType.APPLICATION_JSON_VALUE)
public class BloodTransfusionCenterController {

    @Autowired
    private BloodTransfusionCenterService bloodTransfusionCenterService;
    @Autowired
    private AddressService addressService;
    @Autowired

    private MedicalStaffService medicalStaffService;

    private AppointmentHistoryService appointmentHistoryService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<BloodTransfusionCenterDTO> getBloodCenter(@PathVariable Integer id) {

        BloodTransfusionCenter center = bloodTransfusionCenterService.findOne(id);

        // studen must exist
        if (center == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new BloodTransfusionCenterDTO(center), HttpStatus.OK);
    }
    @GetMapping(value="/address/{id}")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<AddressDTO> getAdressCenter(@PathVariable String id){
        Integer id1 = Integer.parseInt(id);
        Address address = addressService.findOne(id1);
        if(address == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new AddressDTO(address),HttpStatus.OK);
    }
    @GetMapping(value="/search/name={name}")
    public ResponseEntity<List<TransfusionCenterDTO>> getCentersByName(@PathVariable String name){
        return new ResponseEntity<>(bloodTransfusionCenterService.searchByName(name),HttpStatus.OK);
    }
    @GetMapping(value="/search/city_name={name}")
    public ResponseEntity<List<TransfusionCenterDTO>> getCentersByCityName(@PathVariable String name){
        return new ResponseEntity<>(bloodTransfusionCenterService.searchByCityName(name),HttpStatus.OK);
    }

    @GetMapping(value="/admins/{id}")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<List<CenterAdminDTO>> getOtherCenterAdmins(@PathVariable Integer id){
        //traze se polozeni ispiti studenta, sto znaci da moramo uputiti JOIN FETCH upit
        //kako bismo dobili sve trazene podatke
        //BloodTransfusionCenter center = bloodTransfusionCenterService.findAll();

        //ako je podesen fetchType LAZY i pozovemo findOne umesto findOneWithExams,
        //na poziv getExams bismo dobili LazyInitializationException
        List<MedicalStaff> admins = medicalStaffService.findAll();
        List<CenterAdminDTO> adminss = new ArrayList<>();
        for (MedicalStaff a : admins) {
            if(a.getId()!=1) {
                CenterAdminDTO adminDTO = new CenterAdminDTO();
                adminDTO.setId(a.getId());
                adminDTO.setFirstName(a.getFirstName());
                adminDTO.setLastName(a.getLastName());
                adminDTO.setPhoneNumber(a.getPhoneNumber());
                adminDTO.setAddress(a.getAddress());

                adminss.add(adminDTO);
            }
        }
        return new ResponseEntity<>(adminss, HttpStatus.OK);
    }
    @GetMapping(value="/blood/{centerId}")
    public ResponseEntity<List<BloodBank>> getBloodbanks(@PathVariable Integer centerId){
        //traze se polozeni ispiti studenta, sto znaci da moramo uputiti JOIN FETCH upit
        //kako bismo dobili sve trazene podatke


        //ako je podesen fetchType LAZY i pozovemo findOne umesto findOneWithExams,
        //na poziv getExams bismo dobili LazyInitializationException
        List<BloodBank> bloodbanks = bloodTransfusionCenterService.getTransfusionCenterBloodBanks(centerId);
        List<BloodBank> bloodBankList = new ArrayList<>();
        for (BloodBank b : bloodbanks) {


            bloodBankList.add(b);

                     }
        return new ResponseEntity<>(bloodBankList, HttpStatus.OK);
    }

    @PutMapping(path = "/update",consumes = "application/json")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<BloodTransfusionCenterDTO> updateCenter(@RequestBody BloodTransfusionCenterDTO centerDTO) {

        // a student must exist
        BloodTransfusionCenter center = bloodTransfusionCenterService.findOne(centerDTO.getId());

        if (center == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

            center.setName(centerDTO.getName());
            center.setAddress(centerDTO.getAddress());
            center.setDescription(centerDTO.getDescription());



        center = bloodTransfusionCenterService.save(center);
        return new ResponseEntity<>(new BloodTransfusionCenterDTO(center), HttpStatus.OK);
    }

    /*@PostMapping(value="/search")
    public ResponseEntity<BloodTransfusionCenterDTO> searchCenters(@RequestBody searchDTO){

    }*/

}
