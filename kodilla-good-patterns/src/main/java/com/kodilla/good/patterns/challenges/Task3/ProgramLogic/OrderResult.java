package com.kodilla.good.patterns.challenges.Task3.ProgramLogic;

public class OrderResult {

    private final String orderId;
    private final Order order;

    public OrderResult(final String orderId, final Order order) {
        this.orderId = orderId;
        this.order = order;
    }

    public String getOuterId() {
        return orderId;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "OrderResult -> " +
                "orderId= '" + orderId + '\'' +
                ", order= " + order;
    }
}
