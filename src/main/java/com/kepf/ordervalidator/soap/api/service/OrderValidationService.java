package com.kepf.ordervalidator.soap.api.service;

//import com.kepf.ordervalidation.soap.api.CustomerRequest;
//import com.kepf.ordervalidation.soap.api.CustomerResponse;
import com.kepf.ordervalidator.model.MarketData;
import com.kepf.ordervalidator.model.Portfolio;
import com.kepf.ordervalidator.service.CustomerService;
import com.kepf.ordervalidator.service.MarketDataService;
import com.kepf.ordervalidator.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderValidationService {

    @Autowired
    private MarketDataService marketDataService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PortfolioService portfolioService;

//    public CustomerResponse validateOrder(CustomerRequest request) {
//        CustomerResponse response = new CustomerResponse();
//
//        MarketData marketData = marketDataService.getMarketData(request.getProduct());
//        double customerBalance = customerService.getCustomerBalance(request.getCustomerId());
//        List<Portfolio>userPortfolios = portfolioService.getPortfolios(request.getCustomerId());
//
//        if(request.getSide().toUpperCase().equals("BUY")){
//            response.setIsValid(confirmBuyOrder(request, customerBalance, marketData));
//        }else{
//            response.setIsValid(confirmSellOrder(request,userPortfolios,marketData));
//
//        }
//
//        return response;
//    }
//
//    public boolean confirmBuyOrder(CustomerRequest request, double customerBalance, MarketData marketData){
//        double shift_price        = marketData.getMax_price_shift();
//        double last_buy_price     = marketData.getAsk_price()+shift_price;
//        double minimum_buy_price  = last_buy_price-shift_price;
//
//        return (customerBalance > (request.getQuantity() * request.getPrice()))&&
//                (request.getQuantity()<=marketData.getBuy_limit()) &&
//                ( request.getPrice()>=minimum_buy_price&&request.getPrice()<=last_buy_price);
//    }
//
//    public boolean confirmSellOrder(CustomerRequest request,List<Portfolio>userPortfolios, MarketData marketData){
//
//        boolean statusResponse = false;
//
//        for (Portfolio portfolio : userPortfolios){
//            double last_sell_price = marketData.getBid_price()+marketData.getMax_price_shift();
//            double minimum_sell_price = marketData.getBid_price()-marketData.getMax_price_shift();
//
//                if (portfolio.getProduct().equals(request.getProduct())) {
//                    statusResponse = (request.getQuantity() <= portfolio.getQuantity()) &&
//                            (request.getQuantity() <= marketData.getSell_limit()) &&
//                            (request.getPrice() >= minimum_sell_price && request.getPrice() <= last_sell_price);
//                }
//        }
//        return statusResponse;
//    }



}
