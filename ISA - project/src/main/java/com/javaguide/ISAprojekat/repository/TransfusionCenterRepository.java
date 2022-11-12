package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransfusionCenterRepository extends JpaRepository<BloodTransfusionCenter, Long> {
}
