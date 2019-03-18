package com.kodilla.good.patterns.challenges.Task4.DataContainers.ProgramDataBase.Interface;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.Flight;

import java.time.LocalDate;
import java.util.Set;

public interface FlightsDatabase {
     Set<Airport> getAirports();
     Set<Flight> getFlights(LocalDate date);
}
