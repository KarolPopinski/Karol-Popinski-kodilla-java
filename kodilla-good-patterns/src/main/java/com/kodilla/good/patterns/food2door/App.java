package com.kodilla.good.patterns.food2door;

import java.util.List;

public class App {

    public static void main(String[] args) {

        OrdersBuffer ordersBuffer = new OrdersBuffer();
        List<OrderRequest> orderedProducts = ordersBuffer.getOrderedProductList();

        OrderProcessor orderProcessor = new OrderProcessor(new EmailService(), new ProductOrderService(), new ProductOrderRepo());
        orderProcessor.process(orderedProducts);

    }
}
