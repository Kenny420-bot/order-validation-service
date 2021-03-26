package com.kepf.ordervalidator.service;


import com.kepf.ordervalidator.model.Customer;
import com.kepf.ordervalidator.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public double getCustomerBalance(int id){
        Optional<Customer> custObj = customerRepository.findById(id);
        custObj.orElseThrow(RuntimeException::new);
        return custObj.get().getAccount_balance();
    }
}
