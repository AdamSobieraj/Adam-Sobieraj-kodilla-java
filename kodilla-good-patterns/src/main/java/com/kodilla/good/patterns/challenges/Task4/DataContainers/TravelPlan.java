package com.kodilla.good.patterns.challenges.Task4.DataContainers;


/*
public interface Comparable<T>
This interface imposes a total ordering on the objects of each class that implements it.
This ordering is referred to as the class's natural ordering, and the class's
compareTo method is referred to as its natural comparison method.
 */

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public final class TravelPlan implements Comparable<TravelPlan>{

    public static final long INTERVAL_IN_MINUTES = 60L;

    private final List<Flight> flights;
    private final Airport from;
    private final Airport to;
    private final LocalDateTime departure;
    private final LocalDateTime arrival;
    private final Duration duration;

    public TravelPlan(final List<Flight> flights) {
        this.flights = flights;

        Flight first = flights.get(0);
        Flight last = flights.get(flights.size() - 1);
        this.from = first.getFrom();
        this.to = last.getTo();
        this.departure = first.getDeparture();
        this.arrival = last.getArrival();
        this.duration = Duration.between(first.getDeparture(), last.getArrival());
    }

    public TravelPlan(final Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("null Flight");
        }

        this.flights = new ArrayList<>();
        this.flights.add(flight);
        this.from = flight.getFrom();
        this.to = flight.getTo();
        this.duration = flight.getDuration();
        this.departure = flight.getDeparture();
        this.arrival = flight.getArrival();
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelPlan tplan = (TravelPlan) o;
        return flights.equals(tplan.flights);
    }

    @Override
    public int hashCode() {
        return flights.hashCode();
    }

    public String toFineString() {
        return "\n" + ">> Travel plan from " + from.getCity() + " to " + to.getCity() + " <<" +
                flights.stream()
                        .map(f -> "\t" + f.toString().replace("\n","\n\t"))
                        .collect(joining("\n", "\n", "\n")) +
                "Total travel time: " + Flight.formatFlightDuration(duration);
    }

    @Override
    public int compareTo(TravelPlan o) {
        final int EQUAL = 0;

        if (this == o) return EQUAL;
        int comparison = this.from.compareTo(o.from);
        if (comparison != EQUAL) { return comparison; }
        comparison = this.to.compareTo(o.to);
        if (comparison != EQUAL) { return comparison; }
        comparison = this.departure.compareTo(o.departure);
        if (comparison != EQUAL) { return comparison; }
        return this.duration.compareTo(o.duration);
    }
}
