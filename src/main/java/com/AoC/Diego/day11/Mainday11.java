package com.AoC.Diego.day11;

public class Mainday11 {

    public static void main(String[] args) {

        PathFinder finder = new PathFinder();

        // =========================
        // PARTE 1
        // =========================

        String inputPart1 = """
                aaa: you hhh
                you: bbb ccc
                bbb: ddd eee
                ccc: ddd eee fff
                ddd: ggg
                eee: out
                fff: out
                ggg: out
                hhh: ccc fff iii
                iii: out
                """;

        Graph graph1 = new GraphParser().parse(inputPart1);

        int result1 = finder.countPaths(graph1, "you", "out");

        System.out.println("Parte 1: " + result1);

        // =========================
        // PARTE 2
        // =========================

        String inputPart2 = """
                svr: aaa bbb
                aaa: fft
                fft: ccc
                bbb: tty
                tty: ccc
                ccc: ddd eee
                ddd: hub
                hub: fff
                eee: dac
                dac: fff
                fff: ggg hhh
                ggg: out
                hhh: out
                """;

        Graph graph2 = new GraphParser().parse(inputPart2);

        int result2 = finder.countPathsPassingThrough(
                graph2,
                "svr",
                "out",
                "dac",
                "fft"
        );

        System.out.println("Parte 2: " + result2);
    }
}