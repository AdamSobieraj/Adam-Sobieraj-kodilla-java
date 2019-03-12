package com.kodilla.good.patterns.challenges.Task2;

import com.kodilla.good.patterns.challenges.Task2.DataForTesting.OrderRequestFromUser;
import com.kodilla.good.patterns.challenges.Task2.Order.*;

public class AllegroApp {

    public static void main(String[] args) {

        OrderRequestFromUser orderRequestFromUser = new OrderRequestFromUser();
        RequestForOrder request = orderRequestFromUser.retrieve();

        ProductOrderService process = new ProductOrderService(new UserInfoService(), new UserOrderService(), new UserOrderRepository());


        OrderProcessResult orderProcessResult = process.process(request);
        if(orderProcessResult == null) {
            System.out.println("ERROR: " + "Order failed : " + request);
        }
        if (!orderProcessResult.isUserInformed()) {
            System.out.println(" Warning failed, inform oser ");
        }
        if (!orderProcessResult.isOrderStored()) {
            System.out.println("Order storage in repository failed. ");
        }

        System.out.println(orderProcessResult);
    }

}
