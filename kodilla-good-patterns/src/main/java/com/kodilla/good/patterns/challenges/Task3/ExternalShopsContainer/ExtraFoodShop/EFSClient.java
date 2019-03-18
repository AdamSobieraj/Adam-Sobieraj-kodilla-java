package com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.ExtraFoodShop;

import java.util.ArrayList;
import java.util.List;

public class EFSClient {
    private static int count = 0;

    public static List<EFSOffer> fetch() {
        List<EFSOffer> offers = new ArrayList<>();
        offers.add(new EFSOffer("Orang", "kg", 5.0, 4.0));
        offers.add(new EFSOffer("milk", "l", 3.0, 60.7));
        return offers;
    }

    public static String send(EFSOrder order) {
        return "Outer order EFS/" + (++count);
    }
}
