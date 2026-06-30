package com.AoC.Diego.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircuitService {

    private List<Point> parseInput(List<String> input) {

        List<Point> points = new ArrayList<>();

        for (String line : input) {
            String[] values = line.split(",");

            points.add(new Point(
                    Integer.parseInt(values[0]),
                    Integer.parseInt(values[1]),
                    Integer.parseInt(values[2])
            ));
        }

        return points;
    }

    private List<Edge> buildEdges(List<Point> points) {

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {

            for (int j = i + 1; j < points.size(); j++) {

                edges.add(new Edge(
                        i,
                        j,
                        points.get(i).distance(points.get(j))
                ));
            }
        }

        Collections.sort(edges);

        return edges;
    }

    public long solvePart1(List<String> input, int connections) {

        List<Point> points = parseInput(input);

        List<Edge> edges = buildEdges(points);

        UnionFind unionFind = new UnionFind(points.size());

        int count = 0;

        for (Edge edge : edges) {

            if (count == connections) {
                break;
            }

            unionFind.union(edge.getFrom(), edge.getTo());
            count++;
        }

        List<Integer> sizes = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < points.size(); i++) {

            int root = unionFind.find(i);

            if (!visited.contains(root)) {
                visited.add(root);
                sizes.add(unionFind.getSize(root));
            }
        }

        sizes.sort(Collections.reverseOrder());

        return (long) sizes.get(0)
                * sizes.get(1)
                * sizes.get(2);
    }

    public long solvePart2(List<String> input) {

        List<Point> points = parseInput(input);

        List<Edge> edges = buildEdges(points);

        UnionFind unionFind = new UnionFind(points.size());

        for (Edge edge : edges) {

            if (unionFind.union(edge.getFrom(), edge.getTo())) {

                if (unionFind.getNumberOfSets() == 1) {

                    return (long)
                            points.get(edge.getFrom()).getX()
                            * points.get(edge.getTo()).getX();
                }
            }
        }

        return -1;
    }
}