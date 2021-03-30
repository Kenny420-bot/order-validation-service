package com.kepf.ordervalidator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false)
    private String product;
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Customer customer;


}
