package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ItemOrderRepository implements OrderRepository{
    @Override
    public boolean createOrder(User user, LocalDateTime orderDate, int productNumber, int quantity, double price) {
        System.out.println("Added to repo!");
        return true;
    }
}
