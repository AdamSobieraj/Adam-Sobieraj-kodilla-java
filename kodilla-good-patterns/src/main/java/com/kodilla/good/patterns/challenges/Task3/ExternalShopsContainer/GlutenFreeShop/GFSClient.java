package com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.GlutenFreeShop;

public class GFSClient {
    private static int count = 0;

    public static String[][] getOffers() {
        String[][] offers = {
                {"sead", "kg", "10.0", "7.7"},
                {"onion", "item", "15", "5.3"},
        };
        return offers;
    }
    public static String sendOrder(String[] order) {
        return "OO/GFS/" + (++count);
    }
}
