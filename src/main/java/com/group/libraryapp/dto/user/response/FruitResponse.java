package com.group.libraryapp.dto.user.response;

public class FruitResponse {
    private long salesAmount;
    private long notSalesAmount;

    public FruitResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
