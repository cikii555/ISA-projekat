package com.javaguide.ISAprojekat.repository;


import com.javaguide.ISAprojekat.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    Complaint findComplaintById(Long id);
}
