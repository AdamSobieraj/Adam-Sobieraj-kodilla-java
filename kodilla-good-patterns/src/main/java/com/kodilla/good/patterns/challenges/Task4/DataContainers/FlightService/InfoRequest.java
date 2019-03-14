package com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.ConnectType;

import java.time.LocalDate;

public final class InfoRequest {
    private final ConnectType conType;
    private final Airport from;
    private final Airport to;
    private final Airport via;
    private final LocalDate travelDate;

    public InfoRequest(final ConnectType conType, final Airport from, final Airport to, final Airport via,
                       final LocalDate travelDate) {
        this.conType = conType;
        this.from = from;
        this.to = to;
        this.via = via;
        this.travelDate = travelDate;
    }

    public ConnectType getConType() {
        return conType;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public Airport getVia() {
        return via;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoRequest that = (InfoRequest) o;
        if (conType != that.conType) return false;
        if (from != that.from) return false;
        if (to != that.to) return false;
        if (via != that.via) return false;
        return travelDate.equals(that.travelDate);
    }

    @Override
    public int hashCode() {
        return  conType.hashCode()+
                from.hashCode() +
                to.hashCode() +
                via.hashCode() +
                travelDate.hashCode();
    }

    @Override
    public String toString() {
        return  "  conType= " + conType +
                ", from= " + from +
                ", to= " + to +
                ", via= " + via +
                ", travelDate= " + travelDate;
    }
}
