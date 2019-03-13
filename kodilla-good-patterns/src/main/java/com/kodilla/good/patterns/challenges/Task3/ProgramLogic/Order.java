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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (Double.compare(order.howMany, howMany) != 0) return false;
        if (Double.compare(order.price, price) != 0) return false;
        if (!date.equals(order.date)) return false;
        return productContainer.equals(order.productContainer);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date.hashCode();
        result = 31 * result + productContainer.hashCode();
        temp = Double.doubleToLongBits(howMany);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
