package com.kodilla.good.patterns.challenges.Task3.ProgramLogic;

import com.kodilla.good.patterns.challenges.Task3.DataContainers.CompanyCointainer;

import java.util.List;

public interface SupplyService {

     CompanyCointainer getProducer();

     List<ProductOffer> getOffers();

     OrderResult process(Order order);

}
