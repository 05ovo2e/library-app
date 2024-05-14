package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.FruitCreateRequest;
import com.group.libraryapp.dto.user.request.FruitUpdateRequest;
import com.group.libraryapp.dto.user.response.FruitResponse;
import com.group.libraryapp.repository.user.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    // C
    public void saveFruit(FruitCreateRequest request) {
        fruitRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    // R
    public FruitResponse getFruit(String name) {
        if (fruitRepository.isFruitNotExist(name)) {
            throw new IllegalArgumentException();
        }
        return fruitRepository.getFruit(name);
    }

    // U
    public void updateFruit(FruitUpdateRequest request) {
        if (fruitRepository.isFruitNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        fruitRepository.updateFruit(request.getId());
    }
}
