package com.kodilla.good.patterns.challenges;

public class App {

    public static void main(String[] args) {
/*
        MovieStore movieStore = new MovieStore();

        Map<String, List<String>> movies = movieStore.getMovies();

        String moviesTitles = movies.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toSet()).stream()
                .collect(Collectors.joining("!"));

        System.out.println(moviesTitles);
    }
     */

    OrdersBuffer ordersBuffer = new OrdersBuffer();
    OrderRequest orderRequest = ordersBuffer.orderIn();

    OrderProcessor orderProcessor = new OrderProcessor(new EmailService(), new ProductOrderService(), new ItemOrderRepository());
    orderProcessor.process(orderRequest);

    }
}

