package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.user.request.FruitCreateRequest;
import com.group.libraryapp.dto.user.request.FruitUpdateRequest;
import com.group.libraryapp.dto.user.response.FruitResponse;
import com.group.libraryapp.service.user.FruitService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit") // // GET /api/v1/day-of-the-week
    public void saveFruit (@RequestBody FruitCreateRequest request)
    {
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit") // // GET /api/v1/day-of-the-week
    public void updateFruit (@RequestBody FruitUpdateRequest request)
    {
        fruitService.updateFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse getFruit(@RequestParam String name) {
        return fruitService.getFruit(name);
    }

}
