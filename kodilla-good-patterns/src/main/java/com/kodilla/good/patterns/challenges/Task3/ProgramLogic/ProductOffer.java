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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOffer productOffer = (ProductOffer) o;
        if (Double.compare(productOffer.howMany, howMany) != 0) return false;
        if (Double.compare(productOffer.price, price) != 0) return false;
        return productContainer.equals(productOffer.productContainer);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productContainer.hashCode();
        temp = Double.doubleToLongBits(howMany);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return productContainer +
                ", howMany= " + howMany +
                ", price= " + price;
    }
}
