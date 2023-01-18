package com.kodilla.exception.test;

public class App {
    public static void main(String[] args) throws RouteNotFoundException {

        Flight flight = new Flight("WAW", "KRK");
        Flight flight2 = new Flight("WAW", "LAX");
        Flight flight3 = new Flight("WAW", "ZZZ");

        FlightSearch flightSearch = new FlightSearch();

        try {
            flightSearch.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        }

        try {
            flightSearch.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        }

        try {
            flightSearch.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        }
    }
}
