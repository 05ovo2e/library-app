package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.request.FruitGroupby;
import com.group.libraryapp.dto.user.response.FruitResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public class FruitMySqlRepository implements FruitRepository {

    private final JdbcTemplate jdbcTemplate;
    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean isFruitNotExist(long id) {
        String readSql = "SELECT * FROM fruit WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    @Override
    public boolean isFruitNotExist(String name) {
        String readSql = "SELECT * FROM fruit WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    @Override
    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        String sql = "INSERT INTO fruit(name, warehousingDate, price) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }

    @Override
    public void updateFruit(long id) {
        String sql = "UPDATE fruit SET purchase = true WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public FruitResponse getFruit(String name) {
        long salesAmount = 0;
        long notSalesAmount = 0;

        String sumsql = "SELECT purchase, sum(price) as total_price\n" +
                "FROM fruit\n" +
                "WHERE name = ? GROUP BY purchase";

        List<FruitGroupby> responses = jdbcTemplate.query(sumsql, (rs, rowNum) -> {
            boolean purchase = rs.getBoolean("purchase");
            long total_price = rs.getLong("total_price");
            return new FruitGroupby(purchase, total_price);
        }, name);

        for (FruitGroupby response : responses) {
            if (response.isPurchase()) {
                salesAmount += response.getTotal_price();
            }
            else {
                notSalesAmount += response.getTotal_price();
            }
        }

        return new FruitResponse(salesAmount, notSalesAmount);


        /*
        List<Fruit> responses = jdbcTemplate.query(sql, (rs, rowNum) -> {
            boolean purchase = rs.getBoolean("purchase");
            long price = rs.getLong("price");
            return new Fruit(purchase, price);
        }, name);

        for (Fruit response : responses) {
            if (response.isPurchase()) {
                salesAmount += response.getPrice();
            }
            else {
                notSalesAmount += response.getPrice();
            }
        }

        return new FruitResponse(salesAmount, notSalesAmount);

         */


    }

}
