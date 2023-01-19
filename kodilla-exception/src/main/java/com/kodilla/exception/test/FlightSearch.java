package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportsMap = new HashMap<>();
        airportsMap.put("JFK", false);
        airportsMap.put("LGA", true);
        airportsMap.put("MDW", false);
        airportsMap.put("ORD", false);
        airportsMap.put("LAX", true);
        airportsMap.put("BKK", true);
        airportsMap.put("WAW", true);
        airportsMap.put("KRK", false);

        String arrivals = flight.getArrivalAirport();

        if (airportsMap.containsKey(arrivals)) {
            Boolean isAirportAvailable = airportsMap.get(arrivals);
            if (!isAirportAvailable) {
                System.out.println("We're sorry, but your destination airport: "+arrivals+" is not available at the moment.");
            } else {
                System.out.println("All OK, selected destination airport: "+arrivals+" is available.");
            }

        } else {
            throw new RouteNotFoundException("There's no airport like: "+arrivals+
                    "."+"Make sure the IATA Airport is entered correctly.");
        }
    }
}