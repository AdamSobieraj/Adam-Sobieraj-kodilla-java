package com.kodilla.good.patterns.challenges.Task3.ProgramLogic;

import com.kodilla.good.patterns.challenges.Task3.DataContainers.ProductContainer;

import java.time.LocalDateTime;

public class Order {

    private final LocalDateTime date;
    private final ProductContainer productContainer;
    private final double howMany;
    private final double price;
    private final double amount;


    public Order(final LocalDateTime date, final ProductContainer productContainer, final double howMany, final double price) {

        this.date = date;
        this.productContainer = productContainer;
        this.howMany = howMany;
        this.price = price;
        this.amount = Math.round(price * howMany * 100) / 100;
    }

    public Order (final LocalDateTime date, final ProductOffer productOffer, final double howMany) {
        this(date, productOffer.getProduct(), productOffer.getHowMany(), productOffer.getPrice());
    }

    public LocalDateTime getDate() {
        return date;
    }

    public ProductContainer getProduct() {
        return productContainer;
    }

    public double getHowMany() {
        return howMany;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "date= " + date +
                ", product= " + productContainer +
                ", howMany= " + howMany +
                ", price= " + price +
                ", amount= " + amount;
    }

}
