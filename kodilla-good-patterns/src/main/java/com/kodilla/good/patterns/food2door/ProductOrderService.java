package com.kodilla.good.patterns.food2door;

import java.util.List;

public class ProductOrderService implements OrderService{
    @Override
    public boolean order(List<OrderRequest> orderedList) {

        System.out.println("New order to suppliers!!!");
        System.out.println("Ordered products: ");
        System.out.println(printOrderList(orderedList));
        System.out.println();

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HealthyShop healthyShop = new HealthyShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();

        for (OrderRequest order: orderedList) {
            String supplier = order.getSupplier();
            if (supplier == "Extra Food Shop") {
                extraFoodShop.process(order);
            } else if (supplier == "Healthy Shop") {
                healthyShop.process(order);
            }else{
                glutenFreeShop.process(order);
            }
        }
        return true;
    }
    private String printOrderList(List<OrderRequest> printOrderList) {
        String orderList = "";
        for (int i=0; i < printOrderList.size(); i++) {
            OrderRequest orderRequest = printOrderList.get(i);
            String supplier = orderRequest.getSupplier();
            String productType = orderRequest.getProductType();
            int quantity = orderRequest.getQuantity();
            orderList += productType + " " + "x" + quantity + " from: " + supplier +", ";
        }
        return orderList;
    }
}
