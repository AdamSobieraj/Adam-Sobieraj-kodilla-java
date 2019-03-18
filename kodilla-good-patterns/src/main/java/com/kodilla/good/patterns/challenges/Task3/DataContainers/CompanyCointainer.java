package com.kodilla.good.patterns.challenges.Task3.DataContainers;

public final class CompanyCointainer {

    private final String name;
    private final String address;

    public CompanyCointainer(final String name, final String address) {
        this.name = name;
        this.address = address;
    }


    @Override
    public String toString() {
        return  " name= '" + name + '\'' +
                ", address= '" + address;
    }
}
