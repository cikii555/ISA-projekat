package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.model.Address;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address findOne(Integer id) {


        return addressRepository.findById(1).orElseGet(null);

    }
}
