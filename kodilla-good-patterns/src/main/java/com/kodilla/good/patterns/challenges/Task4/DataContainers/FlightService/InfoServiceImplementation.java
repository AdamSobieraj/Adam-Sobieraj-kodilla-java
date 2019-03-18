package com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.ConnectType;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.Flight;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.ProgramDataBase.Interface.FlightsDatabase;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.TravelPlan;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class InfoServiceImplementation implements InfoService {
    private final FlightsDatabase localDataBase;

    public InfoServiceImplementation(FlightsDatabase localDataBase) {
        if (localDataBase == null) {
            throw new IllegalArgumentException("Database null");
        }
        this.localDataBase = localDataBase;
    }

    @Override
    public Set<Airport> getAirports() {
        return localDataBase.getAirports();
    }

    @Override
    public List<TravelPlan> getTravelPlans(InfoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request is null");
        }

        ConnectType connectionType = request.getConnectionType();
        Airport from = request.getFrom();
        Airport to = request.getTo();
        Airport threw = request.getVia();
        LocalDate date = request.getTravelDate();

        switch (connectionType) {
            case DIRECT_FROM:
            case DIRECT_TO:
            case DIRECT_FROM_TO:
                return prepareDirectTravels(connectionType, from, to, date);
            case DIRECT_OR_INDIRECT_FROM_TO:
            case INDIRECT_FROM_TO_THREW:
                return prepareTravels(connectionType, from, to, threw, date);
            default:
                throw new IllegalArgumentException("unknown connection type");
        }
    }

    private List<TravelPlan> prepareDirectTravels(ConnectType conType, final Airport from, final Airport to,
                                                  LocalDate date) {
        Predicate<Flight> checkDirection;
        switch (conType) {
            case DIRECT_FROM_TO:
                checkDirection = f -> f.isFromTo(from, to);
                break;
            case DIRECT_FROM:
                checkDirection = f -> f.isFrom(from);
                break;
            case DIRECT_TO:
                checkDirection = f -> f.isTo(to);
                break;
            default:
                throw new IllegalArgumentException(conType + " is not suitable here");
        }

        List<TravelPlan> tplist = localDataBase.getFlights(date).stream()
                .filter(checkDirection)
                .map(TravelPlan::new)
                .collect(toList());
        Collections.sort(tplist);

        return tplist;
    }

    private List<TravelPlan> prepareTravels(ConnectType conType, final Airport from, final Airport to,
                                            final Airport via, LocalDate date) {
        boolean allowDirect = false;
        Predicate<Flight> checkDirection;
        switch (conType) {
            case DIRECT_OR_INDIRECT_FROM_TO:
                checkDirection = f -> f.isFromOrTo(from, to);
                allowDirect = true;
                break;
            case INDIRECT_FROM_TO_THREW:
                checkDirection = f -> f.isFromTo(from, via) || f.isFromTo(via, to);
                break;
            default:
                throw new IllegalArgumentException(conType + " is not suitable here");
        }

        boolean mapKeyFrom = true;
        boolean mapKeyTo = false;
        Map<Boolean, List<Flight>> m;
        m = localDataBase.getFlights(date).stream()
                .filter(checkDirection)
                .collect(partitioningBy(f -> f.isFrom(from) == mapKeyFrom));
        m.entrySet().stream()
                .map(Map.Entry::getValue)
                .forEach(Collections::sort);

        List<TravelPlan> tplist = new ArrayList<>();
        for(Flight f1 : m.get(mapKeyFrom)) {
            if (allowDirect && f1.isTo(to)) {
                tplist.add(new TravelPlan(f1));
                continue;
            }
            for(Flight f2 : m.get(mapKeyTo)) {
                LocalDateTime minDeparture = f1.getArrival().plus(Duration.ofMinutes(TravelPlan.INTERVAL_IN_MINUTES));
                if (f2.isFrom(f1.getTo()) && minDeparture.isBefore(f2.getDeparture())) {
                    tplist.add(new TravelPlan(Arrays.asList(f1, f2)));
                    break;
                }
            }
        }
        Collections.sort(tplist);

        return tplist;
    }
}
