package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {
    @Override
    public boolean order(final User user, final LocalDateTime orderDate, final int productNumber, final int quantity, final double price) {

        System.out.println("Order for: " + user.getName() + " " + user.getSurname()+
                " order date: " + orderDate + " product number: " + productNumber+
                " quantity: " + quantity + " price: " + price + "zł");
        return true;
    }
}
