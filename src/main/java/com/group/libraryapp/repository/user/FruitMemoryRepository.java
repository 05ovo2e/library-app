package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.FruitResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@Primary
public class FruitMemoryRepository implements FruitRepository {

    private final JdbcTemplate jdbcTemplate;
    public FruitMemoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean isFruitNotExist(long id) {
        return false;
    }

    @Override
    public boolean isFruitNotExist(String name) {
        return false;
    }

    @Override
    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        System.out.println("saveFruit of Fruit Memory Repository");
    }

    @Override
    public void updateFruit(long id) {
        System.out.println("updateFruit of Fruit Memory Repository");
    }

    @Override
    public FruitResponse getFruit(String name) {
        return new FruitResponse(0, 0);
    }

}
