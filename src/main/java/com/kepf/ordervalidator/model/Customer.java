package com.kepf.ordervalidator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private double account_balance;
    private boolean is_active;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Orders> orders;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Portfolio> portfolios;
}
