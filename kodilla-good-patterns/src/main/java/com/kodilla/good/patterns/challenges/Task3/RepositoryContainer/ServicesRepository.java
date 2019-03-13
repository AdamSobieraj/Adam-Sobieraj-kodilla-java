package com.kodilla.good.patterns.challenges.Task3.RepositoryContainer;

import com.kodilla.good.patterns.challenges.Task3.DataContainers.CompanyCointainer;
import com.kodilla.good.patterns.challenges.Task3.ProgramLogic.SupplyService;

import java.util.ArrayList;
import java.util.List;

public final class ServicesRepository {
    private static final List<SupplyService> OFFERS = new ArrayList<>();
    static {
        OFFERS.add(new EFSSupplyService(new CompanyCointainer("ExtraFoodShop", "ul. Toszka 3"), "user1"));
        OFFERS.add(new GFSSupplyService(new CompanyCointainer("GlutenFreeShop", "ul. Glutenowa 2"), "user2"));
        OFFERS.add(new HSSupplyService(new CompanyCointainer("HealthyShop", "ul. Duppaaa 2"), "user3"));
    }

    public static List<SupplyService> getOffers() {
        return new ArrayList<>(OFFERS);
    }

    private ServicesRepository() {
    }

}
