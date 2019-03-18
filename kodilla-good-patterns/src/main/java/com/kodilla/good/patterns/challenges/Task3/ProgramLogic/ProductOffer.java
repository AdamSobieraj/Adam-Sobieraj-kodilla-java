package com.kodilla.good.patterns.challenges.Task3.ProgramLogic;

import com.kodilla.good.patterns.challenges.Task3.DataContainers.ProductContainer;

public class ProductOffer {

    private final ProductContainer productContainer;
    private final double howMany;
    private final double price;

    public ProductOffer(final ProductContainer productContainer, final double howMany, final double price) {
        this.productContainer = productContainer;
        this.howMany = howMany;
        this.price = price;
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

    @Override
    public String toString() {
        return productContainer +
                ", howMany= " + howMany +
                ", price= " + price;
    }
}
