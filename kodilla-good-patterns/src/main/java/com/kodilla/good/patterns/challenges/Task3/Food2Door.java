package com.kodilla.good.patterns.challenges.Task3;

import com.kodilla.good.patterns.challenges.Task3.ProgramLogic.SupplyService;
import com.kodilla.good.patterns.challenges.Task3.RepositoryContainer.ServicesRepository;

import java.util.List;

public class Food2Door {

    public static void main(String[] args) {
        List<SupplyService> services = ServicesRepository.getOffers();
        new Example(services).useServices();
    }
}
