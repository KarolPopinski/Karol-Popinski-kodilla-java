package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeShop implements Supplier {

    private String supplierName;
    private List<Product> supplierProductList = new ArrayList<>();

    public GlutenFreeShop() {
        this.supplierName = "Gluten Free Shop";
        createSupplierProductList();
    }

    @Override
    public String getSupplierName() {
        return supplierName;
    }

    private void createSupplierProductList() {
        Product gfBread = new Product("Gluten Free Bread 1000g", 1896, 1000);
        Product gfSoup = new Product("Gluten Free Soup 200g", 1123, 1000);
        Product gfCocoa = new Product("Gluten Free Cocoa 100g", 1321, 1000);
        Product gfPasta = new Product("Gluten Free Pasta 350g", 1457, 1000);

        supplierProductList.add(gfBread);
        supplierProductList.add(gfSoup);
        supplierProductList.add(gfCocoa);
        supplierProductList.add(gfPasta);
    }

    @Override
    public void process(OrderRequest order) {

        if (checkStock(order) && checkAvailability(order)) {
            System.out.println("Order for products from: " + supplierName);
            System.out.println("Product: " + order.getProductType() + " quantity " + order.getQuantity());
            stockReduction(order);
            System.out.println();
        }else{
            System.out.println("Product out of stock");
        }
    }

    private boolean checkStock(OrderRequest order) {
        List<String> productList = new ArrayList<>();
        for (Product product : supplierProductList) {
            productList.add(product.getProductType());
        }
        if (productList.contains(order.getProductType())) {
            return true;
        } else {
            return false;
        }
    }


    private boolean checkAvailability(OrderRequest order) {
        boolean productFound = false;
        for (Product product : supplierProductList) {
            if (product.productType == order.getProductType())
                if (order.getQuantity() <= product.getQuantity())
                    productFound = true;
        }
        if (productFound) {
            return true;
        } else {
            return false;
        }
    }

    private void stockReduction(OrderRequest order) {
        for (Product product : supplierProductList) {
            if (product.getProductType() == order.getProductType()) {
                product = new Product(product.getProductType(),
                          product.getProductNumber(), product.getQuantity() - order.getQuantity());
                System.out.println("Quantity of " + product.getProductType() + " reduced to: " + product.getQuantity());
            }
        }
    }

}

