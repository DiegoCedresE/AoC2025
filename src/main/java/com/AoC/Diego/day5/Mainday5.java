package com.AoC.Diego.day5;

public class Mainday5 {

    public static void main(String[] args) {

        String input =
                "3-5\n" +
                        "10-14\n" +
                        "16-20\n" +
                        "12-18\n" +
                        "\n" +
                        "1\n" +
                        "5\n" +
                        "8\n" +
                        "11\n" +
                        "17\n" +
                        "32";

        InputParser parser = new InputParser();
        ParsedInput data = parser.parse(input);

        InventoryService service = new InventoryService();

        int part1 = service.countFresh(data.getRanges(), data.getIds());
        int part2 = service.countFreshIds(data.getRanges());

        System.out.println("Parte 1: " + part1); // 3
        System.out.println("Parte 2: " + part2); // 14
    }
}