package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank,Long> {

        List<BloodBank> findBloodBankByBloodTransfusionCenterId(Integer bloodTransfusionCenterId);


}
