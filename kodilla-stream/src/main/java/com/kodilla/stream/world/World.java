package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {

    private Set<Continent> continentsSet = new HashSet<>();

    public void addContinent(Continent continent) {
        continentsSet.add(continent);
    }
    public Set<Continent> getContinentsSet() {
        return new HashSet<>(continentsSet);
    }
    public BigDecimal getPeopleQuantity() {
        BigDecimal populationOfWorld = getContinentsSet().stream()
                .flatMap(continent -> continent.getCountrySet().stream())
                .map(Country::getQuantityOfPeople)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return populationOfWorld;
    }
}
