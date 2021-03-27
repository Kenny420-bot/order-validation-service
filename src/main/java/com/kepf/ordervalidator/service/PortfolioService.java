package com.kepf.ordervalidator.service;

import com.kepf.ordervalidator.model.Portfolio;
import com.kepf.ordervalidator.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

   @Autowired
   private PortfolioRepository portfolioRepository;

    public List<Portfolio> getPortfolios(Integer customerId){
        return portfolioRepository.getCustomerPortfolio(customerId);
    }
}
