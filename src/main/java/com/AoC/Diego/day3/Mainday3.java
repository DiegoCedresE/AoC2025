package com.AoC.Diego.day3;

public class Mainday3 {

    public static void main(String[] args) {

        String input = """
                987654321111111
                811111111111119
                234234234234278
                818181911112111
                """;

        JoltageCalculator calculator = new JoltageCalculator();

        long part1 = calculator.calculatePart1(input);
        long part2 = calculator.calculatePart2(input);

        System.out.println("=== Battery Joltage ===");
        System.out.println("Parte 1: " + part1);
        System.out.println("Parte 2: " + part2);
    }
}