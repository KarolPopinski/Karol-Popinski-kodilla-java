package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public final class Continent {

    private final String continentName;
    private Set<Country> countrySet = new HashSet<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public Set<Country> getCountrySet() {
        return new HashSet<>(countrySet);
    }

    public void addCountry(Country country) {
        countrySet.add(country);
    }
}
