package com.group.libraryapp.domain.fruit;

import java.time.LocalDate;
import java.util.List;

public class FruitList {

    private String name;
    private long price;
    private LocalDate warehousingDate;

    public FruitList(Fruit fruit) {
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = fruit.getWarehousing_date();

    }

    public FruitList(String name, long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
