package Task2.Order.OrderInterfaces;

import Task2.Order.Order;
import Task2.Order.RequestForOrder;

public interface OrderService {
    public Order order(RequestForOrder requestForOrder);
}
