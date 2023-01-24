package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.Address;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.repository.TransfusionCenterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransfusionCenterService {
    private final TransfusionCenterRepository transfusionCenterRepository;

    public TransfusionCenterService(TransfusionCenterRepository transfusionCenterRepository) {
        this.transfusionCenterRepository = transfusionCenterRepository;
    }
    public List<TransfusionCenterDTO> getAll(){
        List<BloodTransfusionCenter> centers= transfusionCenterRepository.findAll();
        List<TransfusionCenterDTO> dtos = new ArrayList<>();
        for(BloodTransfusionCenter c:centers){
            TransfusionCenterDTO dto = new TransfusionCenterDTO(c.getName(), c.getAddress().getCountry(), c.getAddress().getCity(), c.getAddress().getStreet(), c.getAddress().getStreetNumber(), c.getDescription(), c.getAverageGrade(), c.getWorkHours().getStartTime(), c.getWorkHours().getEndTime(), c.getAddress().getLon(), c.getAddress().getLat());
            dtos.add(dto);
        }
        return  dtos;
    }
    public BloodTransfusionCenter getByName(String name){
        return transfusionCenterRepository.getBloodTransfusionCenterByName(name);
    }
}
