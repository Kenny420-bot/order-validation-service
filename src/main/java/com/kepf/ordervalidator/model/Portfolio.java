package com.kepf.ordervalidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name="portfolio")
@Table
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String product;
    private Integer quantity;

    @ManyToOne
    private Customer customer;
}
