package com.javaguide.ISAprojekat.dto.repository;

import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface TransfusionCenterRepository extends JpaRepository<BloodTransfusionCenter,Integer> {




    @Query("select c from BloodTransfusionCenter c join fetch c.medicalStaff e where c.id =?1")
    public BloodTransfusionCenter findOneWithAdmins(Integer studentId);
}
