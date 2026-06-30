package com.AoC.Diego.day11;
/**
 * Convierte la entrada del problema en un grafo.
 */
public class GraphParser {
    /**
     * Analiza la entrada y construye el grafo correspondiente.
     *
     * @param input representación textual del grafo.
     * @return grafo obtenido a partir de la entrada.
     */
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