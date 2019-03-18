package com.kodilla.good.patterns.challenges.Task4.DataContainers.ProgramDataBase;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.Flight;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.ProgramDataBase.Interface.FlightsDatabase;

import java.time.LocalDate;
import java.util.*;

import static com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport.*;

public class DefaultFlightsDatabase implements FlightsDatabase {
    private static final Map<LocalDate, Set<Flight>> FLIGHT_PLANS = new HashMap<>();

    @Override
    public Set<Airport> getAirports() {
        return EnumSet.allOf(Airport.class);
    }

    @Override
    public Set<Flight> getFlights(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException();
        }
        if (!FLIGHT_PLANS.containsKey(date)) {
            FLIGHT_PLANS.put(date, planFlights(date));
        }

        return new HashSet<>(FLIGHT_PLANS.get(date));
    }

    private static Set<Flight> planFlights(LocalDate date) {
        Set<Flight> flights = new HashSet<>();
        flights.add(new Flight(EPGD, EPKK, date, 06, 15, 67));
        flights.add(new Flight(EPGD, EPKK, date, 14, 05, 67));
        flights.add(new Flight(EPGD, EPKK, date, 22, 40, 67));
        flights.add(new Flight(EPGD, EPWA, date, 07, 05, 50));
        flights.add(new Flight(EPGD, EPWA, date, 15, 40, 50));

        return flights;
    }
}
