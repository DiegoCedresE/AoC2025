package com.AoC.Diego.day3;

public class JoltageCalculator {

    private final JoltageStrategy strategy = new JoltageStrategy();

    public long calculatePart1(String input) {

        long total = 0;

        String[] banks = input.strip().split("\\R");

        for (String bank : banks) {
            total += strategy.calculateTwo(bank);
        }

        return total;
    }

    public long calculatePart2(String input) {

        long total = 0;

        String[] banks = input.strip().split("\\R");

        for (String bank : banks) {
            total += strategy.calculateTwelve(bank);
        }

        return total;
    }
}