package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.model.Complaint;
import com.javaguide.ISAprojekat.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {
    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }
    public Complaint respondToComplaint(Complaint complaint, Long id){
        Complaint respondedComplaint = complaintRepository.findComplaintById(id);
        respondedComplaint.setResponse(complaint.getResponse());
        return complaintRepository.save(respondedComplaint);
    }
}
