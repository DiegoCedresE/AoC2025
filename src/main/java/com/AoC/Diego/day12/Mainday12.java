package com.AoC.Diego.day12;

import java.util.*;

public class Mainday12 {
    public static void main(String[] args) {

        String input =
                "0:\n" +
                        "###\n" +
                        "##.\n" +
                        "##.\n" +
                        "\n" +
                        "1:\n" +
                        "###\n" +
                        "##.\n" +
                        ".##\n" +
                        "\n" +
                        "2:\n" +
                        ".##\n" +
                        "###\n" +
                        "##.\n" +
                        "\n" +
                        "3:\n" +
                        "##.\n" +
                        "###\n" +
                        "##.\n" +
                        "\n" +
                        "4:\n" +
                        "###\n" +
                        "#..\n" +
                        "###\n" +
                        "\n" +
                        "5:\n" +
                        "###\n" +
                        ".#.\n" +
                        "###\n" +
                        "\n" +
                        "4x4: 0 0 0 0 2 0\n" +
                        "12x5: 1 0 1 0 2 2\n" +
                        "12x5: 1 0 1 0 3 2";

        // ===== PARSE DE SHAPES =====
        Map<Integer, Shape> shapes = new HashMap<>();

        String[] parts = input.split("\n\n");

        for (String block : parts) {
            if (!block.contains(":")) continue;

            String[] lines = block.split("\n");
            if (lines[0].contains("x")) break; // empieza la parte de regiones

            int index = Integer.parseInt(lines[0].replace(":", ""));

            List<Point> points = new ArrayList<>();

            for (int y = 1; y < lines.length; y++) {
                String line = lines[y];
                for (int x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '#') {
                        points.add(new Point(x, y - 1));
                    }
                }
            }

            shapes.put(index, new Shape(points));
        }

        // ===== PARSE DE REGIONES =====
        List<String> regionLines = Arrays.stream(input.split("\n"))
                .filter(l -> l.contains("x"))
                .toList();

        PuzzleSolver solver = new PuzzleSolver();

        int count = 0;

        for (String line : regionLines) {

            String[] partsLine = line.split(":");
            String[] size = partsLine[0].split("x");

            int width = Integer.parseInt(size[0]);
            int height = Integer.parseInt(size[1]);

            String[] reqsStr = partsLine[1].trim().split(" ");

            Map<Shape, Integer> requirements = new HashMap<>();

            for (int i = 0; i < reqsStr.length; i++) {
                int qty = Integer.parseInt(reqsStr[i]);
                if (qty > 0) {
                    requirements.put(shapes.get(i), qty);
                }
            }

            Board board = new Board(width, height);

            if (solver.canFit(board, requirements)) {
                count++;
            }
        }
        System.out.println("Regiones que pueden contener todos los regalos: " + count);
    }
}