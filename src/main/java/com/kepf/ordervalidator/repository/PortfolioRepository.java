package com.kepf.ordervalidator.repository;

import com.kepf.ordervalidator.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {

    @Query("SELECT p FROM portfolio p WHERE p.customer.id = ?1")
    List<Portfolio> getCustomerPortfolio(Integer customerId);

}
