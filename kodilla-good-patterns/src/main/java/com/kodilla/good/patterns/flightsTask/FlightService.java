package com.kodilla.good.patterns.flightsTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    public List<Flight> getFlightSchedule() {

        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("Kraków", "Bydgoszcz"));
        flights.add(new Flight("Kraków", "Gdańsk"));
        flights.add(new Flight("Kraków", "Olsztyn-Mazury"));
        flights.add(new Flight("Kraków", "Warszawa"));
        flights.add(new Flight("Kraków", "Szczecin"));
        flights.add(new Flight("Warszawa", "Bydgoszcz"));
        flights.add(new Flight("Warszawa", "Katowice"));
        flights.add(new Flight("Warszawa", "Kraków"));
        flights.add(new Flight("Warszawa", "Lublin"));
        flights.add(new Flight("Warszawa", "Poznań"));
        flights.add(new Flight("Warszawa", "Rzeszów"));
        flights.add(new Flight("Warszawa", "Szczecin"));
        flights.add(new Flight("Warszawa", "Wrocław"));
        flights.add(new Flight("Warszawa", "Zielona Góra"));
        flights.add(new Flight("Katowice", "Warszawa"));
        flights.add(new Flight("Gdańsk", "Kraków"));
        flights.add(new Flight("Gdańsk", "Lublin"));
        flights.add(new Flight("Gdańsk", "Rzeszów"));
        flights.add(new Flight("Gdańsk", "Warszawa"));
        flights.add(new Flight("Gdańsk", "Zielona Góra"));
        flights.add(new Flight("Gdańsk", "Łódź"));
        flights.add(new Flight("Wrocław", "Olsztyn-Mazury"));
        flights.add(new Flight("Wrocław", "Warszawa"));
        flights.add(new Flight("Wrocław", "Łódź"));
        flights.add(new Flight("Poznań", "Warszawa"));
        flights.add(new Flight("Rzeszów", "Warszawa"));
        flights.add(new Flight("Rzeszów", "Gdańsk"));
        flights.add(new Flight("Rzeszów", "Olsztyn-Mazury"));
        flights.add(new Flight("Szczecin", "Warszawa"));
        flights.add(new Flight("Szczecin", "Kraków"));
        flights.add(new Flight("Lublin", "Gdańsk"));
        flights.add(new Flight("Lublin", "Warszawa"));
        flights.add(new Flight("Bydgoszcz", "Warszawa"));
        flights.add(new Flight("Bydgoszcz", "Kraków"));
        flights.add(new Flight("Łódź", "Gdańsk"));
        flights.add(new Flight("Łódź", "Wrocław"));
        flights.add(new Flight("Olsztyn-Mazury", "Kraków"));
        flights.add(new Flight("Olsztyn-Mazury", "Rzeszów"));
        flights.add(new Flight("Olsztyn-Mazury", "Wrocław"));
        flights.add(new Flight("Zielona Góra", "Warszawa"));
        flights.add(new Flight("Zielona Góra", "Gdańsk"));

        return flights;
    }

    public List<Flight> searchByDepartureAirport(String departureAirport) {
        return getFlightSchedule().stream()
                .filter(f -> f.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toList());
    }
    public List<Flight> searchByArrivalAirport(String arrivalAirport) {
        return getFlightSchedule().stream()
                .filter(f -> f.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
    }

    public List<Flight> searchConnectingFlight(String departureAirport, String arrivalAirport) {
        List<Flight> departureAirports = getFlightSchedule().stream()
                .filter(f -> f.getDepartureAirport().equals(departureAirport))
                .toList();

        List<Flight> arrivalAirports = getFlightSchedule().stream()
                .filter(f -> f.getArrivalAirport().equals(arrivalAirport))
                .toList();

        List<Flight> connectionflights = new ArrayList<>();

        for (Flight departure : departureAirports) {
            for (Flight arrival : arrivalAirports) {
                if (departure.getArrivalAirport().equals(arrival.getDepartureAirport()))
                    connectionflights.add(departure);
                connectionflights.add(arrival);
            }
        }
        return connectionflights;
    }
}
