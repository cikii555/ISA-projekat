package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.repository.TransfusionCenterRepository;
import net.bytebuddy.build.BuildLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodTransfusionCenterService {

    @Autowired
    private TransfusionCenterRepository transfusionCenterRepository;


    public  BloodTransfusionCenter findOne(Integer id) {


        return transfusionCenterRepository.findById(1).orElseGet(null);

    }
    public BloodTransfusionCenter save(BloodTransfusionCenter center) {
        return transfusionCenterRepository.save(center);
    }
    public BloodTransfusionCenter findOneWithAdmins(Integer Id) {
        return transfusionCenterRepository.findOneWithAdmins(Id);
    }
}
