package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitCount;
import com.group.libraryapp.domain.fruit.FruitList;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.user.request.FruitCreateRequest;
import com.group.libraryapp.dto.user.request.FruitUpdateRequest;
import com.group.libraryapp.dto.user.response.FruitResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FruitServiceV2 {

    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    // C
    public void saveFruit(FruitCreateRequest request) {
        Fruit fruit = fruitRepository.save(new Fruit(request.getName(),
                request.getWarehousingDate(), request.getPrice()));

    }

    // R
    public FruitResponse getFruit(String name) {
        long salesAmount = 0;
        long notSalesAmount = 0;

        List<Fruit> fruits = fruitRepository.findAllByName(name);
        if (fruits.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (Fruit fruit : fruits) {
            if (fruit.isPurchase()) {
                salesAmount += fruit.getPrice();
            }
            else {
                notSalesAmount += fruit.getPrice();
            }
        }

        return new FruitResponse(salesAmount, notSalesAmount);

    }

    public FruitCount getFruitCount(String name) {
        List<Fruit> fruits = fruitRepository.findAllByNameAndPurchase(name, true);
        if (fruits.isEmpty()) {
            throw new IllegalArgumentException();
        }

        long salesCount = 0;
        for (Fruit fruit : fruits) {
            salesCount += 1;
        }

        return new FruitCount(salesCount);
    }

    public List<FruitList> getFruitList(String option, long price) {

        List<FruitList> fruitLists = new ArrayList<>();
        if (option.equals("GTE")) {
            List<Fruit> fruits = fruitRepository.findAllByPurchaseAndPriceGreaterThanEqual(false, price);
            for (Fruit fruit: fruits) {
                fruitLists.add(new FruitList(fruit));
            }
            return fruitLists;

        }
        else if (option.equals("LTE")){
            List<Fruit> fruits = fruitRepository.findAllByPurchaseAndPriceLessThanEqual(false, price);
            for (Fruit fruit: fruits) {
                fruitLists.add(new FruitList(fruit));
            }

            return fruitLists;
        }
        else { throw new IllegalArgumentException(); }

    }

    // U
    public void updateFruit(FruitUpdateRequest request) {

        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        fruit.updateFruit(request.getId());
        fruitRepository.save(fruit);

    }
}
