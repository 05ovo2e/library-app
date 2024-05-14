package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.FruitResponse;

import java.time.LocalDate;

public interface FruitRepository {

    public boolean isFruitNotExist(long id);
    public boolean isFruitNotExist(String name);
    public void saveFruit(String name, LocalDate warehousingDate, long price);
    public void updateFruit(long id);
    public FruitResponse getFruit(String name);

}
