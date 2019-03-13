package com.kodilla.good.patterns.challenges.Task3.ProgramLogic;

import com.kodilla.good.patterns.challenges.Task3.DataContainers.CompanyCointainer;

import java.util.List;

public interface SupplyService {

    public CompanyCointainer getProducer();

    public List<ProductOffer> getOffers();

    public OrderResult process(Order order);

}
