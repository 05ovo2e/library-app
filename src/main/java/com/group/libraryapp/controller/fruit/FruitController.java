package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.domain.fruit.FruitCount;
import com.group.libraryapp.domain.fruit.FruitList;
import com.group.libraryapp.dto.user.request.FruitCreateRequest;
import com.group.libraryapp.dto.user.request.FruitUpdateRequest;
import com.group.libraryapp.dto.user.response.FruitResponse;
import com.group.libraryapp.service.fruit.FruitServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitServiceV2 fruitServiceV2;

    public FruitController(FruitServiceV2 fruitServiceV2) {
        this.fruitServiceV2 = fruitServiceV2;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit (@RequestBody FruitCreateRequest request)
    {
        fruitServiceV2.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit (@RequestBody FruitUpdateRequest request)
    {
        fruitServiceV2.updateFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse getFruit(@RequestParam String name) {
        return fruitServiceV2.getFruit(name);
    }

    // hw6 #q2
    @GetMapping("/api/v1/fruit/count")
    public FruitCount getFruitCount(@RequestParam String name) {
        return fruitServiceV2.getFruitCount(name);
    }

    // hw6 #q3
    @GetMapping("/api/v1/fruit/list")
    public List<FruitList> getFruitList(@RequestParam String option, Integer price) {
        return fruitServiceV2.getFruitList(option, price);
    }

}
