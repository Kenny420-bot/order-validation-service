package com.kepf.ordervalidator.soap.api.service;

import com.kepf.order_validation.soap.api.CustomerRequest;
import com.kepf.order_validation.soap.api.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderValidationService {

    public CustomerResponse validateOrder(CustomerRequest request) {
        CustomerResponse response = new CustomerResponse();
        response.setIsValid(true);
        response.setReason("Price is reasonable");
        response.setOrderId("Order1234");

        return response;

    }

}
