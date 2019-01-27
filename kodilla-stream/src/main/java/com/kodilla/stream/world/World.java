package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {

    private final Set<Continent> continents = new HashSet<>();

    public void addContinents(Continent continent) {
        continents.add(continent);
    }

    public boolean removeContinents(Continent continent) {
        return continents.remove(continent);
    }

    public BigDecimal getPeolpeQuantity() {
        BigDecimal peopleOnWorldCount =  continents.stream()
                .flatMap( continent -> continent.getCountries().stream())
                .distinct()
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, continents) -> sum.add(continents));

    return peopleOnWorldCount;
    }
}
