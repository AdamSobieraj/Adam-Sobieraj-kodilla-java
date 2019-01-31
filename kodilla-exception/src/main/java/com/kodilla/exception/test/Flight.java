package com.kodilla.exception.test;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o){
        final Flight e = (Flight) o;
        return this.departureAirport.equals(e.departureAirport) &&
                this.arrivalAirport.equals(e.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return departureAirport.hashCode()+ arrivalAirport.hashCode();
    }

    @Override
    public String toString(){
        return departureAirport + " from to  " + arrivalAirport ;
    }



}
