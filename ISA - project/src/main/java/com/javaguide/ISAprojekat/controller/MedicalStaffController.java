package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.BloodTransfusionCenterDTO;
import com.javaguide.ISAprojekat.dto.CenterAdminDTO;
import com.javaguide.ISAprojekat.dto.PasswordDTO;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.MedicalStaff;
import com.javaguide.ISAprojekat.service.MedicalStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/medical-staff")
public class MedicalStaffController {
    @Autowired
    private MedicalStaffService medicalStaffService;

    @GetMapping(value="/{id}")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<CenterAdminDTO> getCenterAdmin(@PathVariable  Integer id){

        MedicalStaff centeradmin = medicalStaffService.findOne(id);
        if(centeradmin == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CenterAdminDTO(centeradmin), HttpStatus.OK);
    }

    @PutMapping( path="/update",consumes = "application/json")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<CenterAdminDTO> updateCenterAdmin(@RequestBody CenterAdminDTO centeradminDTO){
        MedicalStaff admin = medicalStaffService.findOne(centeradminDTO.getId());

        if (admin == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            admin.setFirstName(centeradminDTO.getFirstName());
            admin.setLastName(centeradminDTO.getLastName());
            admin.setEmail(centeradminDTO.getEmail());
            admin.setPhoneNumber(centeradminDTO.getPhoneNumber());
            admin.setAddress(centeradminDTO.getAddress());



        admin = medicalStaffService.save(admin);
        return new ResponseEntity<>(new CenterAdminDTO(admin), HttpStatus.OK);
    }
    @PutMapping(path="/password",consumes = "application/json")
    @PreAuthorize("hasRole('MEDICALSTAFF')")
    public ResponseEntity<CenterAdminDTO> updateCenterAdminPassword(@RequestBody PasswordDTO passwordDTO){
        MedicalStaff centeradmin = medicalStaffService.findOne(passwordDTO.getId());

        if(centeradmin == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else if((centeradmin.getPassword().equals(passwordDTO.getOldPassword()))){
            centeradmin.setPassword(passwordDTO.getNewPassword());
            centeradmin = medicalStaffService.save(centeradmin);
            return new ResponseEntity<>(new CenterAdminDTO(centeradmin), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

}
