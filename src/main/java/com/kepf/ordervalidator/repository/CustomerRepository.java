package com.kepf.ordervalidator.repository;

import com.kepf.ordervalidator.model.Customer;
import com.kepf.ordervalidator.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
