package com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.TravelPlan;

import java.util.List;
import java.util.Set;

public interface InfoService {

    Set<Airport> getAirports();
    List<TravelPlan> getTravelPlans(InfoRequest request);

}
