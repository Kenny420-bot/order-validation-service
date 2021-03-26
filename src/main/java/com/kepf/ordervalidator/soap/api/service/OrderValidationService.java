package com.kepf.ordervalidator.soap.api.service;

import com.kepf.ordervalidation.soap.api.CustomerRequest;
import com.kepf.ordervalidation.soap.api.CustomerResponse;
import com.kepf.ordervalidator.model.MarketData;
import com.kepf.ordervalidator.model.Portfolio;
import com.kepf.ordervalidator.service.CustomerService;
import com.kepf.ordervalidator.service.MarketDataService;
import com.kepf.ordervalidator.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderValidationService {

    @Autowired
    private MarketDataService marketDataService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PortfolioService portfolioService;

    public CustomerResponse validateOrder(CustomerRequest request) {
        CustomerResponse response = new CustomerResponse();

        MarketData marketData = marketDataService.getMarketData(request.getProduct());
        double customerBalance = customerService.getCustomerBalance(request.getCustomerId());
        List<Portfolio>userPortfolios = portfolioService.getPortfolios(request.getCustomerId());

        if(request.getSide().equals("BUY")){

            response.setIsValid(confirmBuyOrder(request, customerBalance));

        }else if(request.getSide().equals("SELL")){

            for (Portfolio portfolio : userPortfolios){

                if (portfolio.getProduct().equals(request.getProduct())){

                    double reasonable_price_check = marketData.getBID_PRICE();
                    double reasonable_price_high_range = reasonable_price_check +  0.20;
//                    double reasonable_price_low_range  = reasonable_price_check - 0.20;

                    response.setIsValid(request.getPrice()>reasonable_price_high_range );

                }
            }
        }

        return response;
    }

    public boolean confirmBuyOrder(CustomerRequest request, double customerBalance){
        return customerBalance > (request.getQuantity() * request.getPrice());
    }

    public boolean confirmSellOrder(){
        return true;
    }



}
