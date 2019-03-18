package com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.HealthyShop;

public class HSClient {
    private static int count = 0;

    public static String[][] getOffers() {
        String[][] offers = {
                {"Tomato", "kg", "12.0", "7.7"},
                {"onion", "item", "20", "5.3"},
        };
        return offers;
    }
    public static String sendOrder(String[] order) {
        return "OO/HS/" + (++count);
    }
}
