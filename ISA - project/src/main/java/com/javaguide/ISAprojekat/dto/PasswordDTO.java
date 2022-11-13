package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.MedicalStaff;

public class PasswordDTO {
private Integer id;
    private String oldPassword;
    private String newPassword;

    public PasswordDTO(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public PasswordDTO() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
