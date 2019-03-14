package com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.ExtraFoodShop;

public class EFSOffer {
    private final String productName;
    private final String measure;
    private double quantity;
    private final double price;

    public EFSOffer(final String productName, final String measure, final double quantity, final double price) {
        this.productName = productName;
        this.measure = measure;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public String getMeasure() {
        return measure;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "productName= '" +  productName + '\'' +
                ", measure= '" + measure + '\'' +
                ", quantity= " + quantity +
                ", price= " + price;
    }
}
