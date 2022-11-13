package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.model.LoyaltyProgram;
import com.javaguide.ISAprojekat.repository.LoyaltyProgramRepository;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyProgramService {
    private final LoyaltyProgramRepository loyaltyProgramRepository;

    public LoyaltyProgramService(LoyaltyProgramRepository loyaltyProgramRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
    }

    public LoyaltyProgram insertLoyaltyProgram(LoyaltyProgram loyaltyProgram){
        return loyaltyProgramRepository.save(loyaltyProgram);
    }
}
