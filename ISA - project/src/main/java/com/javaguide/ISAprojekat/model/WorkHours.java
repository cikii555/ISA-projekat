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

}
