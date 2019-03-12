package com.kodilla.good.patterns.challenges.Task2.Order;

import com.kodilla.good.patterns.challenges.Task2.Order.OrderInterfaces.OrderRepository;

public class UserOrderRepository implements OrderRepository {

    @Override
    public boolean create(Order order) {
        // Database
        return true;
    }

}
