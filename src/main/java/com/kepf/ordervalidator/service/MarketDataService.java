package com.kepf.ordervalidator.service;

import com.kepf.ordervalidator.model.MarketData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarketDataService {

    public MarketData getMarketData(String product){
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        String URL = "http://exchange.matraining.com/md/"+product;
        return restTemplate.getForObject(URL, MarketData.class);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }

}
