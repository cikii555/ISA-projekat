package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public interface TransfusionCenterRepository extends JpaRepository<BloodTransfusionCenter,Integer> {
    @Query(value = "SELECT * FROM blood_transfusion_center b where b.name like concat('%', :query,'%')",nativeQuery = true)
    public ArrayList<BloodTransfusionCenter> searchBloodTransfusionCentersbyname(String query);

    @Query(value = "SELECT * FROM blood_transfusion_center b inner join address a ON b.address_id=a.id where a.city like concat('%',:query,'%')",nativeQuery = true)
    public ArrayList<BloodTransfusionCenter> searchBloodTransfusionCentersbycityname(String query);
    @Query("select c from BloodTransfusionCenter c join fetch c.medicalStaff e where c.id =?1")
    public BloodTransfusionCenter findOneWithAdmins(Integer studentId);

    public BloodTransfusionCenter getBloodTransfusionCenterByName(String name);
//=======
//
//public interface TransfusionCenterRepository extends JpaRepository<BloodTransfusionCenter, Long> {
//    public BloodTransfusionCenter getBloodTransfusionCenterByName(String name);
//>>>>>>> HomePageClient
}
