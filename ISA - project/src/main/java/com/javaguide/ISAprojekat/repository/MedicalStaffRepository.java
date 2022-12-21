package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.MedicalStaff;
import com.javaguide.ISAprojekat.model.MedicalStaffType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicalStaffRepository extends JpaRepository<MedicalStaff,Integer> {


    public List<MedicalStaff> findMedicalStaffByBloodTransfusionCenterId(Integer BloodTransfusionCenterId);

}
