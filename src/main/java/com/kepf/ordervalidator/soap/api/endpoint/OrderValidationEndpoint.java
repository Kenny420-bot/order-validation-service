package com.kepf.ordervalidator.soap.api.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kepf.ordervalidation.soap.api.CustomerRequest;
import com.kepf.ordervalidation.soap.api.CustomerResponse;
import com.kepf.ordervalidator.model.Customer;
import com.kepf.ordervalidator.model.Orders;
import com.kepf.ordervalidator.redis.config.RedisConfig;
import com.kepf.ordervalidator.service.CustomerService;
import com.kepf.ordervalidator.service.OrderService;
import com.kepf.ordervalidator.soap.api.service.OrderValidationService;
import com.kepf.ordervalidator.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OrderValidationEndpoint {

    private static final String NAMESPACE = "http://www.kepf.com/ordervalidation/soap/api";

    @Autowired
    private OrderValidationService service;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    private RedisConfig redisConfig;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public CustomerResponse getOrderStatus(@RequestPayload CustomerRequest request) throws JsonProcessingException {

        CustomerResponse response = service.validateOrder(request);
        Customer customer = customerService.getCustomer(request.getCustomerId());


        Orders newOrder = Helpers.newOrder(request,response.isIsValid(), customer);
        ObjectMapper mapper = new ObjectMapper();

        if(response.isIsValid()){

            String tradeRequest = mapper.writeValueAsString(request);
            redisConfig.redisTemplate().convertAndSend(redisConfig.tradingTopic().getTopic(), tradeRequest);
            orderService.createNewOrder(newOrder);

        }

        System.out.println("Sending soap response........");

        return response;
    }

}
