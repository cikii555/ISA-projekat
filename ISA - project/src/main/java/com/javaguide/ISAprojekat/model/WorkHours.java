package com.javaguide.ISAprojekat.model;
import javax.persistence.*;
import java.time.LocalTime;
@Entity
public class WorkHours {
       @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
       @Column
        private LocalTime startTime;
       @Column
        private LocalTime endTime;
//    @OneToOne(mappedBy = "workHours")
//    @JoinColumn(name="bloodTransfusionCenter_id")
//    private BloodTransfusionCenter bloodTransfusionCenter;

    public Long getId() {
        return id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

//    public BloodTransfusionCenter getBloodTransfusionCenter() {
//        return bloodTransfusionCenter;
//    }
}
