package com.kepf.ordervalidator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "orders")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Customer customer;
    private String product;
    private double price;
    private int quantity;
    private String side;
    private boolean is_valid;
    private boolean is_pending;
    private boolean is_success;


}
