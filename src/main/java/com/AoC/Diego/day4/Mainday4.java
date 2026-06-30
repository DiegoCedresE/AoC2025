package com.AoC.Diego.day4;

public class Mainday4 {

    public static void main(String[] args) {

        String input = """
                ..@@.@@@@.
                @@@.@.@.@@
                @@@@@.@.@@
                @.@@@@..@.
                @@.@@@@.@@
                .@@@@@@@.@
                .@.@.@.@@@
                @.@@@.@@@@
                .@@@@@@@@.
                @.@.@@@.@.
                """;

        PaperRollSolver solver = new PaperRollSolver();

        System.out.println("Parte 1: " + solver.part1(input));
        System.out.println("Parte 2: " + solver.part2(input));
    }
}