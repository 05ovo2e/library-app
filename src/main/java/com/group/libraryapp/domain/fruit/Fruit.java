package com.group.libraryapp.domain.fruit;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private LocalDate warehousing_date;
    @Column
    private long price;
    @Column
    private boolean purchase;

    public String getName() {
        return name;
    }

    public LocalDate getWarehousing_date() {
        return warehousing_date;
    }

    public long getPrice() {
        return price;
    }

    public boolean isPurchase() {
        return purchase;
    }

    protected Fruit() {
    }

    public Fruit(String name, LocalDate warehousing_date, long price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
        }
        this.name = name;
        this.warehousing_date = warehousing_date;
        this.price = price;
        this.purchase = false;
    }

    public void updateFruit(long id) {
        this.purchase = true;
    }
}
