package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final String countryName;
    private final BigDecimal quantityOfPeople;

    public Country(final String countryName, final BigDecimal quantityOfPeople) {
        this.countryName = countryName;
        this.quantityOfPeople = quantityOfPeople;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getQuantityOfPeople() {
        return quantityOfPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {
        return countryName.hashCode();
    }
}
