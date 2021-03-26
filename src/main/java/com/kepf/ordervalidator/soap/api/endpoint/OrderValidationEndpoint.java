package com.kepf.ordervalidator.soap.api.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kepf.ordervalidation.soap.api.CustomerRequest;
import com.kepf.ordervalidation.soap.api.CustomerResponse;
import com.kepf.ordervalidator.redis.config.RedisConfig;
import com.kepf.ordervalidator.soap.api.service.OrderValidationService;
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
    private RedisConfig redisConfig;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public CustomerResponse getOrderStatus(@RequestPayload CustomerRequest request) throws JsonProcessingException {
        CustomerResponse response = service.validateOrder(request);

        ObjectMapper mapper = new ObjectMapper();

        if(response.isIsValid()){
            String tradeRequest = mapper.writeValueAsString(request);
            redisConfig.redisTemplate().convertAndSend(redisConfig.tradingTopic().getTopic(), tradeRequest);
        }

        System.out.println("Sending soap response........");
        return response;
    }

}
