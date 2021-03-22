package com.kepf.ordervalidator.soap.api.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kepf.ordervalidation.soap.api.CustomerRequest;
import com.kepf.ordervalidation.soap.api.CustomerResponse;
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

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public CustomerResponse getOrderStatus(@RequestPayload CustomerRequest request) throws JsonProcessingException {
        CustomerResponse response = service.validateOrder(request);
//        ObjectMapper mapper = new ObjectMapper();
//        String responseString = mapper.writeValueAsString(response);
//        System.out.println("publishing to reporting service.....");
//
//        String tradeRequest = mapper.writeValueAsString(request);
//        redisTemplate.convertAndSend(reportingTopic.getTopic(), responseString);
//        redisTemplate.convertAndSend(tradingTopic.getTopic(), tradeRequest);
        System.out.println("Sending soap response........");
        return response;
    }

}
