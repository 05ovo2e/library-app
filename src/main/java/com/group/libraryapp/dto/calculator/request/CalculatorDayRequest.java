package com.group.libraryapp.dto.calculator.request;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalculatorDayRequest {
    private final DayOfWeek dayOfTheWeek;

    public DayOfWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public CalculatorDayRequest(String date) {
        LocalDate dateParse = LocalDate.parse(date);
        this.dayOfTheWeek = dateParse.getDayOfWeek();
    }

}
