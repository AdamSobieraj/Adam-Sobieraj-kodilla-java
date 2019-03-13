package com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.ExtraFoodShop;

import java.time.LocalDateTime;

public class EFSOrder {
    private LocalDateTime date;
    private final String productName;
    private final String measure;
    private double quantity;
    private final double price;

    public EFSOrder(final LocalDateTime date, final String productName, final String measure, final double quantity,
                    final double price) {
        this.date = date;
        this.productName = productName;
        this.measure = measure;
        this.quantity = quantity;
        this.price = price;
    }

}
