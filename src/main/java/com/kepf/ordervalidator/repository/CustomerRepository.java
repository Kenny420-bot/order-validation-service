package com.kepf.ordervalidator.repository;

import com.kepf.ordervalidator.model.Customer;
import com.kepf.ordervalidator.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM customer c JOIN FETCH c.orders WHERE c.id = ?1 ")
    Optional<Customer> getSingleCustomer(Integer customerId);
}
