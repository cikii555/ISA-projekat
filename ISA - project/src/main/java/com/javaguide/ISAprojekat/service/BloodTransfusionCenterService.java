package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.repository.TransfusionCenterRepository;
import net.bytebuddy.build.BuildLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodTransfusionCenterService {

    private final TransfusionCenterRepository transfusionCenterRepository;

    public BloodTransfusionCenterService(TransfusionCenterRepository transfusionCenterRepository) {
        this.transfusionCenterRepository = transfusionCenterRepository;
    }


    public  BloodTransfusionCenter findOne(Integer id) {


        return transfusionCenterRepository.findById(1).orElseGet(null);

    }
    public BloodTransfusionCenter save(BloodTransfusionCenter center) {
        return transfusionCenterRepository.save(center);
    }
    public BloodTransfusionCenter findOneWithAdmins(Integer Id) {
        return transfusionCenterRepository.findOneWithAdmins(Id);
    }
//    public List<TransfusionCenterDTO> getAll(){
//        List<BloodTransfusionCenter> centers= transfusionCenterRepository.findAll();
//        List<TransfusionCenterDTO> dtos = new ArrayList<>();
//        for(BloodTransfusionCenter c:centers){
//            TransfusionCenterDTO dto = new TransfusionCenterDTO(c.getName(), c.getAddress().getCountry(), c.getAddress().getCity(), c.getAddress().getStreet(), c.getAddress().getStreetNumber(), c.getDescription(), c.getAverageGrade(), c.getWorkHours().getStartTime(), c.getWorkHours().getEndTime());
//            dtos.add(dto);
//        }
//        return  dtos;
//    }
//    public BloodTransfusionCenter getByName(String name){
//        return transfusionCenterRepository.getBloodTransfusionCenterByName(name);
//    }

    public List<TransfusionCenterDTO> searchByName(String query) {

        List<BloodTransfusionCenter> centers= transfusionCenterRepository.searchBloodTransfusionCentersbyname(query);
        List<TransfusionCenterDTO> dtos = new ArrayList<>();

        for(BloodTransfusionCenter c:centers){
            TransfusionCenterDTO dto = new TransfusionCenterDTO(c.getName(), c.getAddress().getCountry(), c.getAddress().getCity(), c.getAddress().getStreet(), c.getAddress().getStreetNumber(), c.getDescription(), c.getAverageGrade(), c.getWorkHours().getStartTime(), c.getWorkHours().getEndTime());
            dtos.add(dto);
        }
        return dtos;

    }

    public List<TransfusionCenterDTO> searchByCityName(String query) {
       List<BloodTransfusionCenter> centers=  transfusionCenterRepository.searchBloodTransfusionCentersbycityname(query);
        List<TransfusionCenterDTO> dtos = new ArrayList<>();

        for(BloodTransfusionCenter c:centers){
            TransfusionCenterDTO dto = new TransfusionCenterDTO(c.getName(), c.getAddress().getCountry(), c.getAddress().getCity(), c.getAddress().getStreet(), c.getAddress().getStreetNumber(), c.getDescription(), c.getAverageGrade(), c.getWorkHours().getStartTime(), c.getWorkHours().getEndTime());
            dtos.add(dto);
        }
        return dtos;
    }


}
