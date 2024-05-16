/*
package com.group.libraryapp.service.user;


import com.group.libraryapp.dto.user.request.FruitCreateRequest;
import com.group.libraryapp.dto.user.request.FruitUpdateRequest;
import com.group.libraryapp.dto.user.response.FruitResponse;
import com.group.libraryapp.repository.user.FruitJdbcRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceV1 {
    private final FruitJdbcRepository fruitJdbcRepository;

    public (FruitJdbcRepository fruitJdbcRepository) {
        this.fruitJdbcRepository = fruitJdbcRepository;
    }

    // C
    public void saveFruit(FruitCreateRequest request) {
        fruitJdbcRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    // R
    public FruitResponse  getFruit(String name) {
        if (fruitJdbcRepository.isFruitNotExist(name)) {
            throw new IllegalArgumentException();
        }
        return fruitJdbcRepository.getFruit(name);
    }

    // U
    public void updateFruit(FruitUpdateRequest request) {
        if (fruitJdbcRepository.isFruitNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        fruitJdbcRepository.updateFruit(request.getId());
    }
}
*/