package com.AoC.Diego.day11;
public class PathFinder {

    public int countPaths(Graph graph, String start, String end) {
        return dfs(graph, start, end);
    }

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