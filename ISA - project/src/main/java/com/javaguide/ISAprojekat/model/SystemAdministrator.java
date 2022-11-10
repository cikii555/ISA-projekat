package com.javaguide.ISAprojekat.model;
import javax.persistence.*;
@Entity
public class SystemAdministrator extends User{

    private boolean firstLogin;

    public SystemAdministrator() {
    }
}
