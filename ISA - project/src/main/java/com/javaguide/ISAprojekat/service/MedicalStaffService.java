package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.model.MedicalStaff;
import com.javaguide.ISAprojekat.repository.MedicalStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalStaffService {


    @Autowired
    private MedicalStaffRepository medicalStaffRepository;
    public MedicalStaff findOne(Integer id) {
        return medicalStaffRepository.findById(id).orElseGet(null);

    }

    public MedicalStaff save(MedicalStaff md){
        return medicalStaffRepository.save(md);
    }
}
