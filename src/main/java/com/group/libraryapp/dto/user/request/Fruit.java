package com.group.libraryapp.dto.user.request;

import java.time.LocalDate;

public class Fruit {
    private boolean purchase;
    private long price;

    public boolean isPurchase() {
        return purchase;
    }

    public long getPrice() {
        return price;
    }

    public Fruit(boolean purchase, long price) {
        this.purchase = purchase;
        this.price = price;
    }
}
