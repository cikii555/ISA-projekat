package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.ReportDTO;
import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.BloodBank;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Equipment;
import com.javaguide.ISAprojekat.model.Report;
import com.javaguide.ISAprojekat.repository.BloodBankRepository;
import com.javaguide.ISAprojekat.repository.EquipmentRepository;
import com.javaguide.ISAprojekat.repository.ReportRepository;
import com.javaguide.ISAprojekat.repository.TransfusionCenterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class BloodTransfusionCenterService {

    private final TransfusionCenterRepository transfusionCenterRepository;
    private final BloodBankRepository bloodBankRepository;
    private final EquipmentRepository equipmentRepository;
    private final ReportRepository reportRepository;

    public BloodTransfusionCenterService(TransfusionCenterRepository transfusionCenterRepository, BloodBankRepository bloodBankRepository,
                                         EquipmentRepository equipmentRepository, ReportRepository reportRepository) {
        this.transfusionCenterRepository = transfusionCenterRepository;
        this.bloodBankRepository = bloodBankRepository;
        this.equipmentRepository = equipmentRepository;
        this.reportRepository = reportRepository;
    }


    public  BloodTransfusionCenter findOne(Integer id) {


        return transfusionCenterRepository.findById(1).orElseGet(null);

    }


    public  Equipment findOne(Long id) {


        return equipmentRepository.findById(id).orElseGet(null);

    }

    public BloodTransfusionCenter saveCenter(BloodTransfusionCenter center){

        return transfusionCenterRepository.save(center);
    }
    public Equipment saveEquipment(Equipment equipment){
        return equipmentRepository.save(equipment);
    }
    public Report saveReport(Report report){
        return reportRepository.save(report);
    }
    public BloodBank saveBloodBank(BloodBank bloodBank){
        return bloodBankRepository.save(bloodBank);
    }
    public List<BloodTransfusionCenter> findAll() {
        return transfusionCenterRepository.findAll();
    }
    public BloodTransfusionCenter save(BloodTransfusionCenter center) {
        return transfusionCenterRepository.save(center);
    }
    public BloodTransfusionCenter findOneWithAdmins(Integer Id) {
        return transfusionCenterRepository.findOneWithAdmins(Id);
    }

    public List<BloodBank> getTransfusionCenterBloodBanks(Integer transfusionCenterId){
        return bloodBankRepository.findBloodBankByBloodTransfusionCenterId(transfusionCenterId);
    }

    public List<Equipment> getTransfusionCenterEquipment(Integer transfusionCenterId){
        return equipmentRepository.findEquipmentByBloodTransfusionCenterId(transfusionCenterId);
    }

    public void UpdateBloodBankQuantityForTransfusionCenter(ReportDTO report){
        List<BloodBank> bloodBankList = getTransfusionCenterBloodBanks(report.getCeneterId());
        for(BloodBank bb:bloodBankList){
            if(bb.getBloodType()==report.getBloodType()){
                bb.setQuantity(bb.getQuantity()+report.getQuantity());
                saveBloodBank(bb);
            }
        }
    }
    public void UpdateUsedEquipmentForTransfusionCenter(ReportDTO report,List<Equipment> usedEquipment){
        List<Equipment> equipmentList = getTransfusionCenterEquipment(report.getCeneterId());
        for(Equipment equipment:equipmentList) {
            for (Equipment userq : usedEquipment) {
                if (equipment.getName().equals(userq.getName())) {

                    equipment.setQuantity(equipment.getQuantity() - userq.getQuantity());
                    saveEquipment(equipment);
                }
            }
        }

    }

    public List<Equipment> EquipmentUsedForBloodDonation(ReportDTO report){
        Equipment eq = new Equipment();
        eq.setName("syringes");
        eq.setQuantity(report.getSyringes_qunatity());
        Equipment equ = new Equipment();
        equ.setName("blood_bags");
        equ.setQuantity(report.getBags_quantity());
        List <Equipment> usedEqu = new ArrayList<Equipment>();
        usedEqu.add(eq);
        usedEqu.add(equ);
        return usedEqu;
    }
    public void UpdateBloodTransfusionCenterBloodBanksAndEquipment(ReportDTO report){
        UpdateBloodBankQuantityForTransfusionCenter(report);
        List<Equipment> equipmentList = EquipmentUsedForBloodDonation(report);
        UpdateUsedEquipmentForTransfusionCenter(report,equipmentList);
    }
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
