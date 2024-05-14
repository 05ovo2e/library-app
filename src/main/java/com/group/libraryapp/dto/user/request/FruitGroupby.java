package com.group.libraryapp.dto.user.request;

public class FruitGroupby {
    private boolean purchase;
    private long total_price;

    public boolean isPurchase() {
        return purchase;
    }

    public long getTotal_price() {
        return total_price;
    }

    public FruitGroupby(boolean purchase, long total_price) {
        this.purchase = purchase;
        this.total_price = total_price;
    }
}
