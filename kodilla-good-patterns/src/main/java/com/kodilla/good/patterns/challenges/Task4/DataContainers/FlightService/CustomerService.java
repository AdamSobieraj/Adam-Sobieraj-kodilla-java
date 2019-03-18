package com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.TravelPlan;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    void updateAirports(Set<Airport> airports);
    InfoRequest nextInfoRequest();
    boolean hasNextInfoRequest();
    void replyToInfoRequest(InfoRequest request, List<TravelPlan> tplist);
    void sendError(InfoRequest request);
}
