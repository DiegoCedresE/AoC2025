package com.AoC.Diego.day12;

import java.util.*;

public class Shape {
    private final List<Point> cells;

    public Shape(List<Point> cells) {
        this.cells = normalize(cells);
    }

    public List<List<Point>> getTransformations() {
        Set<String> seen = new HashSet<>();
        List<List<Point>> result = new ArrayList<>();

        List<List<Point>> variants = new ArrayList<>();
        variants.add(cells);

        // 4 rotaciones
        List<Point> current = cells;
        for (int i = 0; i < 4; i++) {
            current = rotate(current);
            variants.add(current);
            variants.add(reflect(current));
        }

        for (List<Point> v : variants) {
            List<Point> norm = normalize(v);
            String key = norm.toString();
            if (seen.add(key)) {
                result.add(norm);
            }
        }

        return result;
    }

    private List<Point> rotate(List<Point> shape) {
        return shape.stream()
                .map(p -> new Point(p.y(), -p.x()))
                .toList();
    }

    private List<Point> reflect(List<Point> shape) {
        return shape.stream()
                .map(p -> new Point(-p.x(), p.y()))
                .toList();
    }

    private List<Point> normalize(List<Point> shape) {
        int minX = shape.stream().mapToInt(Point::x).min().orElse(0);
        int minY = shape.stream().mapToInt(Point::y).min().orElse(0);

        return shape.stream()
                .map(p -> new Point(p.x() - minX, p.y() - minY))
                .sorted(Comparator.comparingInt(Point::x).thenComparingInt(Point::y))
                .toList();
    }
}