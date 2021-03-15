package com.pefk.order_validation_service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public List<Order> getOrders(){
        return List.of(
                new Order("IBM", 20, 40, "BUY"),
                new Order("APPL", 15, 65, "SELL"),
                new Order("MSC", 22, 35, "BUY"),
                new Order("NYSE", 10, 55, "SELL")
        );
    }
}
