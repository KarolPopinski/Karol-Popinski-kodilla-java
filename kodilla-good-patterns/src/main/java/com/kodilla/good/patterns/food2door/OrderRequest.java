package com.kodilla.good.patterns.food2door;

public class OrderRequest {

    private String supplier;
    private String productType;
    private int quantity;

    public OrderRequest(final String supplier, final String productType, final int quantity) {
        this.supplier = supplier;
        this.productType = productType;
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }
}
