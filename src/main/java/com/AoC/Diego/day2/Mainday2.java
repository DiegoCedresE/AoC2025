package com.AoC.Diego.day2;

import java.util.Scanner;

public class Mainday2 {


    public static void main(String[] args) {

        String input =
                "11-22," +
                        "95-115," +
                        "998-1012," +
                        "1188511880-1188511890," +
                        "222220-222224," +
                        "1698522-1698528," +
                        "446443-446449," +
                        "38593856-38593862," +
                        "565653-565659," +
                        "824824821-824824827," +
                        "2121212118-2121212124";

        // ===== PARTE 1 =====
        InvalidRule rulePart1 =
                new RepeatedPatternRule(RepeatedPatternRule.Mode.PART1);

        InvalidIdService servicePart1 =
                new InvalidIdService(rulePart1);

        System.out.println("Parte 1: " + servicePart1.sumInvalidIds(input));

        // ===== PARTE 2 =====
        InvalidRule rulePart2 =
                new RepeatedPatternRule(RepeatedPatternRule.Mode.PART2);

        InvalidIdService servicePart2 =
                new InvalidIdService(rulePart2);

        System.out.println("Parte 2: " + servicePart2.sumInvalidIds(input));
    }
    }