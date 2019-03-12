package Task2;

import Task2.Order.*;
import Task2.Order.OrderInterfaces.*;

public class ProductOrderService {

    private final InformationService infoService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public ProductOrderService(final InformationService infoService,
                          final OrderService orderService,
                          final OrderRepository orderRepo) {
        if (infoService == null || orderService == null || orderRepo == null) {
            throw new IllegalArgumentException();
        }

        this.infoService = infoService;
        this.orderService = orderService;
        this.orderRepository = orderRepo;
    }

    public OrderProcessResult process(final RequestForOrder request) {
        if (request == null) {
            throw new IllegalArgumentException();
        }

        Order order = orderService.order(request);
        if (order == null) { return null; }
        return new OrderProcessResult(order, infoService.inform(order),
                orderRepository.create(order));
    }

}
