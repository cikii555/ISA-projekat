package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.BloodType;

public class ReportDTO {

    private BloodType bloodType;

    private double quantity;

    private double syringes_qunatity;
    private double bags_quantity;
    private Long historyId;

    private Integer ceneterId;

    public ReportDTO(BloodType bloodType, double quantity, double syringes_qunatity, double bags_quantity, Long historyId,Integer centerId) {
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.syringes_qunatity = syringes_qunatity;
        this.bags_quantity = bags_quantity;
        this.historyId = historyId;
        this.ceneterId = centerId;
    }

    public ReportDTO() {
    }

    public Integer getCeneterId() {
        return ceneterId;
    }

    public void setCeneterId(Integer ceneterId) {
        this.ceneterId = ceneterId;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getSyringes_qunatity() {
        return syringes_qunatity;
    }

    public void setSyringes_qunatity(double syringes_qunatity) {
        this.syringes_qunatity = syringes_qunatity;
    }

    public double getBags_quantity() {
        return bags_quantity;
    }

    public void setBags_quantity(double bags_quantity) {
        this.bags_quantity = bags_quantity;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }
}
