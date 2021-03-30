package com.kepf.ordervalidator.service;
import com.kepf.ordervalidator.model.Orders;
import com.kepf.ordervalidator.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Async
    public void createNewOrder(Orders orders){

        orderRepository.save(orders);

    }

}
