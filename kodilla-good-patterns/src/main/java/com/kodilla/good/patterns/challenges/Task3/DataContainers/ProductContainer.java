package com.kodilla.good.patterns.challenges.Task3.DataContainers;

public final class ProductContainer {

    private final CompanyCointainer producerContainer;
    private final String name;
    private final String measure;

    public CompanyCointainer getProducerContainer() {
        return producerContainer;
    }

    public String getName() {
        return name;
    }

    public String getMeasure() {
        return measure;
    }

    public ProductContainer(final CompanyCointainer producerContainer, final String name, final String measure) {
        this.producerContainer = producerContainer;
        this.name = name;
        this.measure = measure;
    }

    @Override
    public String toString() {
        return producerContainer +
                ", name='" + name + '\'' +
                ", measure='" + measure;
    }
}
