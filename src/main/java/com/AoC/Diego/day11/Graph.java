package com.AoC.Diego.day11;

import java.util.*;

public class Graph {

    private final Map<String, List<String>> adjacency = new HashMap<>();

    public void addEdge(String from, String to) {
        adjacency.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    public List<String> getNeighbors(String node) {
        return adjacency.getOrDefault(node, Collections.emptyList());
    }
}