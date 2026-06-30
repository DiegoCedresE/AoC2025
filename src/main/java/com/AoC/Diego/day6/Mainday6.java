package com.AoC.Diego.day6;

public class Mainday6 {

    public static void main(String[] args) {

        String input =
                "123 328  51 64 \n" +
                        " 45 64  387 23 \n" +
                        "  6 98  215 314\n" +
                        "*   +   *   +  ";

        WorksheetSolver solver = new WorksheetSolver();

        long part1 = solver.solvePart1(input);
        long part2 = solver.solvePart2(input);

        System.out.println("PART 1 = " + part1);
        System.out.println("PART 2 = " + part2);
    }
}