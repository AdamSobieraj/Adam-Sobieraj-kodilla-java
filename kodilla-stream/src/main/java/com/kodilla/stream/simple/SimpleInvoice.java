package com.kodilla.stream.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class SimpleInvoice {
    private List<String> test = new ArrayList<>();
    private final List<SimpleItem> items = new ArrayList<>();

    public void addItem(SimpleItem item) {
        items.add(item);
    }

    public boolean removeItem(SimpleItem item) {
        return items.remove(item);
    }

    public double getValueToPay() {
        return items.stream()
                .collect(Collectors.summingDouble(SimpleItem::getValue));
    }

    public List<String> getValue(){
        for (SimpleItem value: items) {
          test.add(value.getProduct().getProductName());
        }
        return test;
    }

}

