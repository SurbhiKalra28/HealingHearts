package com.surbhikalra.healinghearts.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "merchandiseid")
    private Merchandise merchandise;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;


    private int quantity;
    private double cost;

    public double getTotalPrice() {
        return quantity * cost;
    }

}