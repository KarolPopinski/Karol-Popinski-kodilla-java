package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {

    private User user;
    private LocalDateTime orderDate;
    private int productNumber;
    private int quantity;
    private double price;

    public OrderRequest(final User user, final LocalDateTime orderDate, final int productNumber, final int quantity, final double price) {
        this.user = user;
        this.orderDate = orderDate;
        this.productNumber = productNumber;
        this.quantity = quantity;
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
