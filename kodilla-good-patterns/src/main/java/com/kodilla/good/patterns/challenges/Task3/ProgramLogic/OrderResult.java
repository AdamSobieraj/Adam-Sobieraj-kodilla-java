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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderResult that = (OrderResult) o;
        if (!orderId.equals(that.orderId)) return false;
        return order.equals(that.order);
    }

    @Override
    public int hashCode() {
        int result = orderId.hashCode();
        result = 31 * result + order.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderResult -> " +
                "orderId= '" + orderId + '\'' +
                ", order= " + order;
    }
}
