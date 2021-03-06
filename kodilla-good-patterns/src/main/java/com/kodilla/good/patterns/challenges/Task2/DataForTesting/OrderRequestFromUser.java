package com.kodilla.good.patterns.challenges.Task2.DataForTesting;

import com.kodilla.good.patterns.challenges.Task2.Order.RequestForOrder;
import com.kodilla.good.patterns.challenges.Task2.ProgramData.Product;
import com.kodilla.good.patterns.challenges.Task2.ProgramData.UserOfOrder;

public class OrderRequestFromUser {

        private RequestForOrder requestForOrder;

        public OrderRequestFromUser() {
            UserOfOrder userOfOrder = new UserOfOrder(12, "Tomasz", "Wolf", "ul. Targosza 27/3,93-140 Mikołów", "Tomasz@op.pl");
            Product product = new Product(33, "Geforce GTX 2080", 1200.0);
            requestForOrder = new RequestForOrder(userOfOrder, product, 2);
        }

        public RequestForOrder retrieve() { return requestForOrder; }
}
