package com.javaguide.ISAprojekat.model;

import com.javaguide.ISAprojekat.dto.UserRegistrationDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client extends User{
    @Column
    private int penalty;
//    @Column
//    private LoyaltyProgram loyaltyProgram;
    @Column
    private boolean gradedCenter;
    @Column
    private String occupation;
    @Column
    private String organizationInformation;
    @Column
    private boolean filledOutSurvey;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BloodTransfusionCenter> filledOutSurveys;
    public Client() {
    }
    public Client(UserRegistrationDTO userRegistrationDTO) {
        this.setFirstName(userRegistrationDTO.getFirstName());
        this.setLastName(userRegistrationDTO.getLastName());
        this.setEmail(userRegistrationDTO.getEmail());
        this.setJmbg(userRegistrationDTO.getJmbg());
        this.setGender(userRegistrationDTO.getGender());
        this.setOccupation(userRegistrationDTO.getOccupation());
        this.setOrganizationInformation(userRegistrationDTO.getOrganizationInformation());
        this.setAddress(new Address(userRegistrationDTO.getCountry(), userRegistrationDTO.getCity(), userRegistrationDTO.getStreet(), userRegistrationDTO.getStreetNumber()));
        this.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
        this.setPassword(new BCryptPasswordEncoder().encode(userRegistrationDTO.getPassword()));
//        this.setPassword(userRegistrationDTO.getPassword());
        this.setActive(false);
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

//    public LoyaltyProgram getLoyaltyProgram() {
//        return loyaltyProgram;
//    }
//
//    public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
//        this.loyaltyProgram = loyaltyProgram;
//    }

    public boolean isGradedCenter() {
        return gradedCenter;
    }

    public void setGradedCenter(boolean gradedCenter) {
        this.gradedCenter = gradedCenter;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOrganizationInformation() {
        return organizationInformation;
    }

    public void setOrganizationInformation(String organizationInformation) {
        this.organizationInformation = organizationInformation;
    }

    public Set<BloodTransfusionCenter> getFilledOutSurveys() {
        return filledOutSurveys;
    }

    public void setFilledOutSurveys(Set<BloodTransfusionCenter> filledOutSurveys) {
        this.filledOutSurveys = filledOutSurveys;
    }
}
