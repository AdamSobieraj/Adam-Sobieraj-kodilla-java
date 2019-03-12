package com.kodilla.good.patterns.challenges.Task2.ProgramData;

public class Product {

        private final int id;
        private final String name;
        private final double price;

        public Product(final int id, final String name, final double price) {
            if (id <= 0 || name == null || name.isEmpty() || price <= 0.0) {
                throw new IllegalArgumentException();
            }
            this.id = id;
            this.name = name;
            this.price = price;
        }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  " ID= " + id +
                ", name= '" + name + '\'' +
                ", price= " + price;
    }
}
