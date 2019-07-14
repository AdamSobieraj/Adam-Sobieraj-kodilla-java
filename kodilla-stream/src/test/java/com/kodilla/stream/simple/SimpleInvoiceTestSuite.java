package com.kodilla.stream.simple;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleInvoiceTestSuite {

    @Test
    public void testGetValueToPay() {
        //Given
        String check;
        SimpleInvoice invoice = new SimpleInvoice();
        //When
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",  6.49), 5.0));

        for (String testValue:invoice.getValue()) {
             check = testValue;
        }
        //Then


        Assert.assertEquals(108.975, invoice.getValueToPay(), 0.001);
    }
}

