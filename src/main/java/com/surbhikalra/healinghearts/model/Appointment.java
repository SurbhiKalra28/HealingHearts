package com.surbhikalra.healinghearts.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String clientid;
    private String clientname;
    private String appointmentwith;
    private LocalDate date;
    private LocalTime time;

}

