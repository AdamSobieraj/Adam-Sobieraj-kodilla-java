package com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.TravelPlan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.Airport.*;
import static com.kodilla.good.patterns.challenges.Task4.DataContainers.Enums.ConnectType.*;
import static java.time.LocalDate.now;

public class CustomerServiceImplementation implements CustomerService {
    private static final List<InfoRequest> requests = new ArrayList<>();
    static {
        requests.add(new InfoRequest(DIRECT_FROM, EPGD, null, null, now()));
        requests.add(new InfoRequest(DIRECT_TO, null, EPKK, null, now()));
        requests.add(new InfoRequest(DIRECT_FROM_TO, EPGD, EPKK, null, now()));
    }

    private Iterator<InfoRequest> iteration = requests.iterator();

    @Override
    public void updateAirports(Set<Airport> airports) {
        if (airports == null) {
            throw new IllegalStateException("null set");
        }
        System.out.println("Updating airports info");
        airports.stream()
                .map(Airport::toFineString)
                .forEach(System.out::println);
        System.out.println("done.\n");
    }

    @Override
    public InfoRequest nextInfoRequest() {
        return iteration.next();
    }

    @Override
    public boolean hasNextInfoRequest() {
        return iteration.hasNext();
    }

    @Override
    public void replyToInfoRequest(InfoRequest request, List<TravelPlan> tplist) {
        System.out.println("\n"+"Replaying to request " + request);
        if(tplist.isEmpty()) {
            System.out.println("There are no flights for your request");
        }
        tplist.stream()
                .map(tp -> tp.toFineString() + " ")
                .forEach(System.out::println);
    }

    @Override
    public void sendError(InfoRequest request) {
        System.out.println("Error message ");
    }
}
