package com.AoC.Diego.day11;
public class GraphParser {

    public Graph parse(String input) {

        Graph graph = new Graph();

        String[] lines = input.split("\\R");

        for (String line : lines) {

            String[] parts = line.split(":");

            String from = parts[0].trim();

            if (parts.length == 1) {
                continue;
            }

            String[] destinations = parts[1].trim().split("\\s+");

            for (String to : destinations) {
                graph.addEdge(from, to);
            }
        }

        return graph;
    }
}