package com.kodilla.good.patterns.challenges.Task3.DataContainers;

import static com.kodilla.good.patterns.challenges.Task3.ImputDataValidation.ImputValidator.*;

public final class ProductContainer {

    private final CompanyCointainer producerContainer;
    private final String name;
    private final String measure;

    public ProductContainer(final CompanyCointainer producerContainer, final String name, final String measure) {

        inputDataValidation();

        this.producerContainer = producerContainer;
        this.name = name;
        this.measure = measure;
    }

    private void inputDataValidation(){
        validateNotEmpty(producerContainer, "Producer");
        validateString(name, "name");
        validateString(measure, "measure");
    }

    @Override
    public String toString() {
        return "producer=" + producerContainer +
                ", name='" + name + '\'' +
                ", measure='" + measure;
    }
}
