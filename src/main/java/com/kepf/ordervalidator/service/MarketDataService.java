package com.kepf.ordervalidator.service;

import com.kepf.ordervalidator.model.MarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MarketDataService {

    @Autowired
    WebClient.Builder webClientBuilder;
    public MarketData getMarketData(String product){
        String URL = "https://exchange.matraining.com/md/"+product;
        return webClientBuilder.build().get().uri(URL)
                .retrieve()
                .bodyToMono(MarketData.class).block();

    }

}
