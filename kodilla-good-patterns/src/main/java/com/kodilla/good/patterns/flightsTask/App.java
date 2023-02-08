package com.kodilla.good.patterns.flightsTask;

public class App {

    public static void main(String[] args) {

        FlightService flightService = new FlightService();

        System.out.println("1. znalezienie wszystkich lotów z danego miasta");
        System.out.println(flightService.searchByDepartureAirport("Kraków"));
        System.out.println();
        System.out.println("2. znalezienie wszystkich lotów do danego miasta");
        System.out.println(flightService.searchByArrivalAirport("Zielona Góra"));
        System.out.println();
        System.out.println("3. loty łączone/przesiadkowe przez inne miasto");
        System.out.println(flightService.searchConnectingFlight("Kraków", "Zielona Góra"));

    }
}
