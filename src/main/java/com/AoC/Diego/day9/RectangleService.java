package com.AoC.Diego.day9;
import java.util.List;

public class RectangleService {
    public long part1(List<Point> points) {

        long maxArea = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point p2 = points.get(j);
                long area = area(p1, p2);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private long area(Point p1, Point p2) {
        long width = Math.abs(p1.x() - p2.x()) + 1;
        long height = Math.abs(p1.y() - p2.y()) + 1;
        return width * height;
    }


    public long part2(List<Point> points) {

        PolygonService polygon = new PolygonService(points);

        long maxArea = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point p2 = points.get(j);
                long area = area(p1, p2);
                if (polygon.rectangleInside(p1, p2)) {
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        return maxArea;
    }
}
