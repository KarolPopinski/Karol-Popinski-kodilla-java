package com.kodilla.good.patterns.food2door;

import java.util.List;

public class ProductOrderRepo implements OrderRepository {
    @Override
    public boolean createOrder(List<OrderRequest> orderedList) {

        System.out.println("Added new order to repo!");
        System.out.println("Order list: " + printOrderList(orderedList));
        return true;
    }

    private String printOrderList(List<OrderRequest> orderListToPrint) {
        String orderList = "";
        for (int i = 0; i < orderListToPrint.size(); i++) {
            OrderRequest orderRequest = orderListToPrint.get(i);
            String supplier = orderRequest.getSupplier();
            String productType = orderRequest.getProductType();
            int quantity = orderRequest.getQuantity();
            orderList += productType + " " + quantity + " from: " + supplier+", ";
        }
        return orderList;
    }
}
