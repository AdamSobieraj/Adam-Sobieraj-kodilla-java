package com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums;

public enum Airport {
    EPGD("Gdańsk", "Lecha Wałęsy"),
    EPKT("Katowice", "Pyrzowice"),
    EPKK("Kraków", "Jana Pawła"),
    EPPO("Poznań", "Henryka"),
    EPWA("Warszawa", "Chopina"),
    EPWR("Wrocław", "M Kopernika");

    private final String cityOfAirport;
    private final String nameOfAirport;

    private Airport(String cityOfAirport, String nameOfAirport) {
        this.cityOfAirport = cityOfAirport;
        this.nameOfAirport = nameOfAirport;
    }

    public String getCity() {
        return cityOfAirport;
    }

    public String getName() {
        return nameOfAirport;
    }

    public String toFineString() {
        return cityOfAirport + " " + nameOfAirport + " " + '(' + name() + ')';
    }

}
