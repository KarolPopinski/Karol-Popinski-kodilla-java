package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class OrdersBuffer {

    List<OrderRequest> orderedProductList = new ArrayList<>();

    public OrdersBuffer() {
        createOrderList();
    }
    public void createOrderList() {
        OrderRequest item1 = new OrderRequest("Extra Food Shop", "Beef", 1);
        OrderRequest item2 = new OrderRequest("Extra Food Shop", "Bread", 1);
        OrderRequest item3 = new OrderRequest("Extra Food Shop", "Tomatoes", 1);
        OrderRequest item4 = new OrderRequest("Healthy Shop", "Fashion", 1);
        OrderRequest item5 = new OrderRequest("Healthy Shop", "Face Care", 1);
        OrderRequest item6 = new OrderRequest("Gluten Free Shop", "Gluten Free Pasta 350g", 1);
        OrderRequest item7 = new OrderRequest("Gluten Free Shop", "Gluten Free Bread 1000g", 1);

        orderedProductList.add(item1);
        orderedProductList.add(item2);
        orderedProductList.add(item3);
        orderedProductList.add(item4);
        orderedProductList.add(item5);
        orderedProductList.add(item6);
        orderedProductList.add(item7);

    }
    public List<OrderRequest> getOrderedProductList() {
        return orderedProductList;
    }
}
