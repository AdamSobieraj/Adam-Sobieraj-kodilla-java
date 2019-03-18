package com.kodilla.good.patterns.challenges.Task3;

import com.kodilla.good.patterns.challenges.Task3.ProgramLogic.Order;
import com.kodilla.good.patterns.challenges.Task3.ProgramLogic.OrderResult;
import com.kodilla.good.patterns.challenges.Task3.ProgramLogic.ProductOffer;
import com.kodilla.good.patterns.challenges.Task3.ProgramLogic.SupplyService;

import java.time.LocalDateTime;
import java.util.List;

public final class Example {
    private final List<SupplyService> services;

    public Example(final List<SupplyService> services) {
        this.services = services;
    }

    public void useServices() {
        for (SupplyService srv : services) {
            System.out.println("Uploading offers " + srv.getProducer());
            List<ProductOffer> offers = srv.getOffers();
            if (offers == null) {
                System.out.println("error");
                continue;
            }
            if (offers.isEmpty()) {
                System.out.println("No offers");
                continue;
            }
            System.out.println("Display them");
            for (ProductOffer offer : offers) {
                System.out.println(offer.toString());
            }
            System.out.println("Order them all");
            for (ProductOffer offer : offers) {
                OrderResult result = srv.process(new Order(LocalDateTime.now(),offer, offer.getHowMany()));
                if (result == null) {
                    System.out.println("Can't order " + offer.getProduct());
                    continue;
                }
                System.out.println("Order with result:");
                System.out.println(result.toString());
            }
        }
    }
}
