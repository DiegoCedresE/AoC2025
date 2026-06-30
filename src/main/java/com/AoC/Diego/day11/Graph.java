package com.AoC.Diego.day11;
import java.util.*;
/**
 * Representa un grafo dirigido mediante listas de adyacencia.
 */
public class Graph {
    private final Map<String, List<String>> adjacency = new HashMap<>();
    /**
     * Añade una arista desde un nodo origen hasta un nodo destino.
     *
     * @param from nodo de origen.
     * @param to nodo de destino.
     */
    public void addEdge(String from, String to) {
        adjacency.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }
    /**
     * Devuelve los nodos adyacentes a un nodo.
     *
     * @param node nodo del que se quieren obtener sus vecinos.
     * @return lista de nodos adyacentes.
     */
    public List<String> getNeighbors(String node) {
        return adjacency.getOrDefault(node, Collections.emptyList());
    }
}