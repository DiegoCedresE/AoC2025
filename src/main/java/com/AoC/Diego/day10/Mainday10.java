package com.AoC.Diego.day10;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mainday10 {

    public static void main(String[] args) {

        List<Machine> machines = new ArrayList<>();

        // Máquina 1
        machines.add(new Machine(
                new boolean[]{false, true, true, false},
                new int[]{3, 5, 4, 7},
                Arrays.asList(
                        new int[]{3},
                        new int[]{1, 3},
                        new int[]{2},
                        new int[]{2, 3},
                        new int[]{0, 2},
                        new int[]{0, 1}
                )
        ));

        // Máquina 2
        machines.add(new Machine(
                new boolean[]{false, false, false, true, false},
                new int[]{7, 5, 12, 7, 2},
                Arrays.asList(
                        new int[]{0, 2, 3, 4},
                        new int[]{2, 3},
                        new int[]{0, 4},
                        new int[]{0, 1, 2},
                        new int[]{1, 2, 3, 4}
                )
        ));

        // Máquina 3
        machines.add(new Machine(
                new boolean[]{false, true, true, true, false, true},
                new int[]{10, 11, 11, 5, 10, 5},
                Arrays.asList(
                        new int[]{0, 1, 2, 3, 4},
                        new int[]{0, 3, 4},
                        new int[]{0, 1, 2, 4, 5},
                        new int[]{1, 2}
                )
        ));

        Solver part1 = new Part1Solver();
        Solver part2 = new Part2Solver();

        int total1 = 0;
        int total2 = 0;

        for (Machine machine : machines) {
            total1 += part1.solve(machine);
            total2 += part2.solve(machine);
        }

        System.out.println("Parte 1 = " + total1); // Debe imprimir 7
        System.out.println("Parte 2 = " + total2); // Debe imprimir 33
    }
}