package com.AoC.Diego.day6;

import java.util.List;

public class Problem {

    private final List<Long> numbers;
    private final char operation;

    public Problem(List<Long> numbers, char operation) {
        this.numbers = numbers;
        this.operation = operation;
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    public char getOperation() {
        return operation;
    }
}