package com.kodilla.good.patterns.challenges.Task2.Order;

import com.kodilla.good.patterns.challenges.Task2.ProgramData.Product;
import com.kodilla.good.patterns.challenges.Task2.ProgramData.UserOfOrder;

import java.time.LocalDate;

public class Order {
    private final RequestForOrder requestForOrder;
    private final int id;
    private final LocalDate purcheDate;

    public Order(final RequestForOrder requestForOrder, final int id,
                 final LocalDate purcheDate) {
        if (requestForOrder == null || id <= 0 || purcheDate == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.requestForOrder = requestForOrder;
        this.purcheDate = purcheDate;
    }

    public UserOfOrder getUser() {
        return requestForOrder.getUserOfOrder();
    }

    @Override
    public String toString() {
        return  "\n"+
                ", id= " + id +"\n"+
                ", date = " + purcheDate +"\n"+
                ", user = " + requestForOrder.getUserOfOrder() +"\n"+
                ", product = " + requestForOrder.getProduct() +"\n"+
                ", quantity = " + requestForOrder.getHowMany() +"\n"+
                ", amount = " + requestForOrder.getAmount() ;
    }
}
