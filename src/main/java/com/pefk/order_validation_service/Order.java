package com.pefk.order_validation_service;

public class Order {
    private final String product;
    private final int quantity;
    private final int price;
    private final String side;

    public Order(String product, int quantity, int price, String side){
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", side='" + side + '\'' +
                '}';
    }
}
