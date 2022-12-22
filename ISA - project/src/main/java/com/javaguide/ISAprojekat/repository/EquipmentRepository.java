package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.BloodBank;
import com.javaguide.ISAprojekat.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EquipmentRepository  extends JpaRepository<Equipment, Long> {

    List<Equipment> findEquipmentByBloodTransfusionCenterId(Integer bloodTransfusionCenterId);
}
