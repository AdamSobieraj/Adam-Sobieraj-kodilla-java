package com.kodilla.good.patterns.challenges.Task4.DataContainers;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class Flight implements Comparable<Flight> {
    private static final DateTimeFormatter DT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final Airport from;
    private final Airport to;
    private final LocalDateTime departure;
    private final Duration duration;
    // derived
    private final LocalDateTime arrival;
    private final String formattedDuration;

    public Flight(final Airport from, final Airport to, final LocalDate departureDate, final int departureHour,
                  final int departureMinute, final int durationMinutes) {

        this.from = from;
        this.to = to;
        this.departure = LocalDateTime.of(departureDate, LocalTime.of(departureHour, departureMinute));
        this.duration = Duration.ofMinutes(durationMinutes);

        this.arrival = this.departure.plus(this.duration);
        this.formattedDuration = formatFlightDuration(duration);
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public boolean isFrom(Airport from) {
        return this.from.equals(from);
    }

    public boolean isTo(Airport to) {
        return this.to.equals(to);
    }

    public boolean isFromTo(Airport from, Airport to) {
        return isFrom(from) && isTo(to);
    }

    public boolean isFromOrTo(Airport from, Airport to) {
        return isFrom(from) || isTo(to);
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight that = (Flight) o;
        if (from != that.from) return false;
        if (to != that.to) return false;
        if (!departure.equals(that.departure)) return false;
        return duration.equals(that.duration);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + departure.hashCode();
        result = 31 * result + duration.hashCode();
        return result;
    }

    public static String formatFlightDuration(Duration d) {
        long min = d.toMinutes();
        return String.format("%d:%02d", min / 60, min % 60);
    }

    @Override
    public String toString() {
        return   "from= " + from +
                ", to= " + to +
                ", departure= " + departure +
                ", duration= " + duration +
                ", formattedDuration= '" + formattedDuration + '\'' +
                ", arrival= " + arrival;
    }

    @Override
    public int compareTo(Flight o) {
        final int EQUALS_TO = 0;

        if (this == o) return EQUALS_TO;
        int comparison = this.from.compareTo(o.from);
        if (comparison != EQUALS_TO) { return comparison; }
        comparison = this.to.compareTo(o.to);
        if (comparison != EQUALS_TO) { return comparison; }
        comparison = this.departure.compareTo(o.departure);
        if (comparison != EQUALS_TO) { return comparison; }
        return this.duration.compareTo(o.duration);
    }
}
