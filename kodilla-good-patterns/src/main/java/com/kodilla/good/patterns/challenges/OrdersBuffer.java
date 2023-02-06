package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrdersBuffer {

    public OrderRequest orderIn() {

        User user = new User("Jan", "Testowy", "testy@testy.comipl");
        LocalDateTime orderDate = LocalDateTime.of(2023, 2, 22, 10, 45);
        int productNumber = 7778923;
        int quantity = 1;
        double price = 50.00;

        return new OrderRequest(user, orderDate, productNumber, quantity, price);
    }
}
