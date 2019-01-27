package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final BigDecimal quantity;
    private final String countryName;

    public Country(BigDecimal quantity, String countryName) {
        this.quantity = quantity;
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQuantity(){
        return quantity;
    }


}
