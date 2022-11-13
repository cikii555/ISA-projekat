package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.model.Complaint;
import com.javaguide.ISAprojekat.service.ComplaintService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( "*")
@RestController
@RequestMapping(value = "/complaint", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComplaintController {
    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }
    @PatchMapping("/respondToComplaint/{id}")
    public Complaint respondToComplaint(@RequestBody Complaint complaint, @PathVariable Long id){
        return complaintService.respondToComplaint(complaint, id);
    }
}
