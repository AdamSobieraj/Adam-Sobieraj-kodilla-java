package com.kodilla.good.patterns.challenges.Task2.Order.OrderInterfaces;

import com.kodilla.good.patterns.challenges.Task2.Order.Order;
import com.kodilla.good.patterns.challenges.Task2.Order.RequestForOrder;

public interface OrderService {
    public Order order(RequestForOrder requestForOrder);
}
