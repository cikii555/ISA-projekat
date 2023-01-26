package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.repository.BloodDonationAppointmentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BloodDonationAppointmentService {

   private final BloodDonationAppointmentRepository bloodDonationAppointmentRepository;

    public BloodDonationAppointmentService(BloodDonationAppointmentRepository bloodDonationAppointmentRepository) {
        this.bloodDonationAppointmentRepository = bloodDonationAppointmentRepository;
    }

    @Transactional
    public Appointment saveAppointment(Appointment bloodTransfusionAppointment){
        return bloodDonationAppointmentRepository.save(bloodTransfusionAppointment);
    }

}
