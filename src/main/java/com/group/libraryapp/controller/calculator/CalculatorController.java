package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @GetMapping("/add") // GET /add
    public int addTwoNumbers(CalculatorAddRequest request)
    {
        return request.getNumber1() + request.getNumber2();
    }

    @GetMapping("/api/v1/calc") // GET /api/v1/calc
    public Object calcThreeNumbers(@RequestParam int num1, @RequestParam int num2)
    {
        return new CalculatorThreeRequest(num1, num2);
    }

    @GetMapping("/api/v1/day-of-the-week") // // GET /api/v1/day-of-the-week
    public CalculatorDayRequest calcDay(@RequestParam String date)
    {
        return new CalculatorDayRequest(date);
    }

    @PostMapping("/multiply") // POST /multiply
    public int multiplyTwoNumber(@RequestBody CalculatorMultiplyRequest request)
    {
        return request.getNumber1() * request.getNumber2();
    }

    @PostMapping("/sum") // POST /sum
    public int sumArrNumber(@RequestBody CalculatorSumRequest request)
    {
        int sum = 0;
        for (int i = 0; i < request.getNumbers().size(); i++) {
            sum += request.getNumbers().get(i);
        }
        return sum;
    }

}
