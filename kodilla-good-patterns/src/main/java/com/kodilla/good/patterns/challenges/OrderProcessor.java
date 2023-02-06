package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private InformationServie informationServie;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InformationServie informationServie,
                          final OrderService orderService, final OrderRepository orderRepository) {
        this.informationServie = informationServie;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {

        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getOrderDate(),
                orderRequest.getProductNumber(), orderRequest.getQuantity(), orderRequest.getPrice());

        if (isOrdered) {
            informationServie.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getOrderDate(),
                    orderRequest.getProductNumber(), orderRequest.getQuantity(), orderRequest.getPrice());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}