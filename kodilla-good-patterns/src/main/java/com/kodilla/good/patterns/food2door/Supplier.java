package com.kodilla.good.patterns.food2door;

public interface Supplier {

    String getSupplierName();

    void process(OrderRequest order);
}
