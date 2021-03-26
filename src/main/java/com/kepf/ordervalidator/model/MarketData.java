package com.kepf.ordervalidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MarketData {
    private double LAST_TRADED_PRICE;
    private double BID_PRICE;
    private double SELL_LIMIT;
    private double MAX_PRICE_SHIFT;
    private String TICKER;
    private double ASK_PRICE;
    private int BUY_LIMIT;
}