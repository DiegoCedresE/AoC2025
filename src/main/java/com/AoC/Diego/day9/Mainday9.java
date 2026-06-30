package com.AoC.Diego.day9;

import java.util.List;

public class Mainday9 {

    public static void main(String[] args) {

        List<Point> points = List.of(
                new Point(7,1),
                new Point(11,1),
                new Point(11,7),
                new Point(9,7),
                new Point(9,5),
                new Point(2,5),
                new Point(2,3),
                new Point(7,3)
        );

        RectangleService service = new RectangleService();

        System.out.println("Parte 1: " + service.part1(points));
        System.out.println("Parte 2: " + service.part2(points));

    }
}