package com.AoC.Diego.day11;
/**
 * Proporciona métodos para contar caminos entre nodos de un grafo.
 */
public class PathFinder {
    /**
     * Cuenta el número de caminos entre un nodo de origen y uno de destino.
     *
     * @param graph grafo sobre el que se realiza la búsqueda.
     * @param start nodo de origen.
     * @param end nodo de destino.
     * @return número de caminos encontrados.
     */
    public int countPaths(Graph graph, String start, String end) {
        return dfs(graph, start, end);
    }
    /**
     * Recorre el grafo de forma recursiva para contar los caminos
     * entre dos nodos.
     */
    private int dfs(Graph graph, String current, String end) {
        if (current.equals(end)) {
            return 1;
        }
        int total = 0;
        for (String next : graph.getNeighbors(current)) {
            total += dfs(graph, next, end);
        }
        return total;
    }
    /**
     * Cuenta los caminos entre dos nodos que pasan por dos nodos
     * indicados.
     *
     * @param graph grafo sobre el que se realiza la búsqueda.
     * @param start nodo de origen.
     * @param end nodo de destino.
     * @param node1 primer nodo obligatorio.
     * @param node2 segundo nodo obligatorio.
     * @return número de caminos que cumplen la condición.
     */
    public int countPathsPassingThrough(Graph graph,
                                        String start,
                                        String end,
                                        String node1,
                                        String node2) {
        return dfsWithConditions(
                graph,
                start,
                end,
                false,
                false,
                node1,
                node2);
    }
    /**
     * Recorre el grafo de forma recursiva comprobando si el camino
     * pasa por los dos nodos indicados.
     */
    private int dfsWithConditions(Graph graph,
                                  String current,
                                  String end,
                                  boolean visited1,
                                  boolean visited2,
                                  String node1,
                                  String node2) {
        if (current.equals(node1)) {
            visited1 = true;
        }
        if (current.equals(node2)) {
            visited2 = true;
        }
        if (current.equals(end)) {
            return (visited1 && visited2) ? 1 : 0;
        }
        int total = 0;
        for (String next : graph.getNeighbors(current)) {
            total += dfsWithConditions(
                    graph,
                    next,
                    end,
                    visited1,
                    visited2,
                    node1,
                    node2);
        }
        return total;
    }
}