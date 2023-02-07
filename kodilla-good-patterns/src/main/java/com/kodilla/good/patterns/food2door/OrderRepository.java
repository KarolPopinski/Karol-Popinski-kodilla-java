package com.kodilla.good.patterns.food2door;

import java.util.List;

public interface OrderRepository {

    boolean createOrder(List<OrderRequest> orderList);
}
