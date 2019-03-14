package com.kodilla.good.patterns.challenges.Task4;

import com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService.CustomerService;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService.CustomerServiceImplementation;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService.InfoServiceImplementation;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.FlightService.InfoRequest;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.ProgramDataBase.DefaultFlightsDatabase;
import com.kodilla.good.patterns.challenges.Task4.DataContainers.TravelPlan;

import java.util.List;

public class Flights {

    public static void main(String[] args) {
        InfoServiceImplementation is = new InfoServiceImplementation(new DefaultFlightsDatabase());
        CustomerService customerService = new CustomerServiceImplementation();

        customerService.updateAirports(is.getAirports());

        while(customerService.hasNextInfoRequest()) {
            InfoRequest request = customerService.nextInfoRequest();
            List<TravelPlan> tplist = null;
            try {
                tplist = is.getTravelPlans(request);
                customerService.replyToInfoRequest(request, tplist);
            } catch (Exception ex) {
                if (tplist == null) {
                    customerService.sendError(request);
                }
                throw ex;
            }
        }
    }

}
