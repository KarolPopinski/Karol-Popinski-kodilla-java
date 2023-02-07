package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(InformationService informationService, OrderService orderService,
                          OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public void process(final List<OrderRequest> orderedList) {
        boolean isOrdered = orderService.order(orderedList);
        List<String> suppliers = createSuppliersList(orderedList);
        if (isOrdered) {
            for (int i=0; i < suppliers.size(); i++) {
                informationService.inform(suppliers.get(i));
            }
            orderRepository.createOrder(orderedList);
            System.out.println("Order successful!");
        }else{
            System.out.println("Order failed");
        }
    }

    private List<String> createSuppliersList(List<OrderRequest> orderedList) {
        List<String> suppliersAllList = new ArrayList<>();
        for (OrderRequest order : orderedList) {
            suppliersAllList.add(order.getSupplier());
        }
        List<String> suppliersList = suppliersAllList.stream()
                .distinct()
                .collect(Collectors.toList());
        return suppliersList;
    }
}
