package com.javaguide.ISAprojekat.dto.repository;

import com.javaguide.ISAprojekat.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
