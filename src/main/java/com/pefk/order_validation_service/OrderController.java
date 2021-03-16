package com.pefk.order_validation_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/order")
public class OrderController {

    @Autowired
    OrderService order_service;


    @GetMapping
    public List<Order> getOrders(){
        return order_service.getOrders();
    }
}
