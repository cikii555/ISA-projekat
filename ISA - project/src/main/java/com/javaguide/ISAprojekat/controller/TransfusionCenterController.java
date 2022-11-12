package com.javaguide.ISAprojekat.controller;

import com.javaguide.ISAprojekat.dto.TransfusionCenterDTO;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.service.TransfusionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/center", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransfusionCenterController {
    private final TransfusionCenterService transfusionCenterService;

    public TransfusionCenterController(TransfusionCenterService transfusionCenterService) {
        this.transfusionCenterService = transfusionCenterService;
    }
    @GetMapping()
    public ResponseEntity<List<TransfusionCenterDTO>> all() {
        return new ResponseEntity<List<TransfusionCenterDTO>>(transfusionCenterService.getAll(), HttpStatus.OK);
    }
}
