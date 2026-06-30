package com.AoC.Diego.day1;

import java.util.List;

public class Mainday1 {

    public static void main(String[] args) {

        List<Rotation> rotations = List.of(
                new Rotation(Direction.L, 68),
                new Rotation(Direction.L, 30),
                new Rotation(Direction.R, 48),
                new Rotation(Direction.L, 5),
                new Rotation(Direction.R, 60),
                new Rotation(Direction.L, 55),
                new Rotation(Direction.L, 1),
                new Rotation(Direction.L, 99),
                new Rotation(Direction.R, 14),
                new Rotation(Direction.L, 82)
        );

        SafeService service = new SafeService();

        int part1 = service.getPassword(rotations);
        int part2 = service.getPasswordMethod2(rotations);

        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}