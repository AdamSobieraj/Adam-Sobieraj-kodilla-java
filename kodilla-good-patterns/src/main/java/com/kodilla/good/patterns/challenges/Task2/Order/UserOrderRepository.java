package Task2.Order;

import Task2.Order.OrderInterfaces.OrderRepository;

public class UserOrderRepository implements OrderRepository {

    @Override
    public boolean create(Order order) {
        // Database
        return true;
    }

}
