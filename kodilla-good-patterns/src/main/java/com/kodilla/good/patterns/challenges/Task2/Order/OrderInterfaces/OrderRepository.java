package com.kodilla.good.patterns.challenges.Task2.Order.OrderInterfaces;

import com.kodilla.good.patterns.challenges.Task2.Order.Order;

public interface OrderRepository {
    public boolean create(Order order);
}
