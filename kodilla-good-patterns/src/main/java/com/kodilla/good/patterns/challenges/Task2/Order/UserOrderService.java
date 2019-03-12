package com.kodilla.good.patterns.challenges.Task2.Order;

import com.kodilla.good.patterns.challenges.Task2.Order.OrderInterfaces.OrderService;

import java.time.LocalDate;

public class UserOrderService implements OrderService {

    private static int lastId = 0;

    @Override
    public Order order(RequestForOrder requestForOrder) {
        if (requestForOrder == null) {
            throw new IllegalArgumentException();
        }
        return placeOrder(requestForOrder);
    }

    private Order placeOrder(RequestForOrder requestForOrder) {
        // Request propagation

        return new Order(requestForOrder, ++lastId, LocalDate.now());
    }
}
