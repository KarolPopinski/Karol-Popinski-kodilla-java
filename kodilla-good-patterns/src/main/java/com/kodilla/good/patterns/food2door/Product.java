package com.kodilla.good.patterns.food2door;

public class Product {

    String productType;
    int productNumber;
    int quantity;

    public Product(String productType, int productNumber, int quantity) {
        this.productType = productType;
        this.productNumber = productNumber;
        this.quantity = quantity;
    }


    public String getProductType() {
        return productType;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public int getQuantity() {
        return quantity;
    }
}
