package com.AoC.Diego.day9;
import java.util.List;
/**
 * Servicio encargado de calcular el área máxima de los rectángulos
 * definidos por los puntos de entrada.
 */
public class RectangleService {
    /**
     * Obtiene el área máxima del rectángulo formado por cualquier pareja
     * de puntos.
     *
     * @param points lista de puntos.
     * @return área máxima encontrada.
     */
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
    /**
     * Calcula el área del rectángulo definido por dos vértices opuestos.
     *
     * @param p1 primer vértice.
     * @param p2 vértice opuesto.
     * @return área del rectángulo.
     */
    private long area(Point p1, Point p2) {
        long width = Math.abs(p1.x() - p2.x()) + 1;
        long height = Math.abs(p1.y() - p2.y()) + 1;
        return width * height;
    }
    /**
     * Obtiene el área máxima de un rectángulo completamente contenido
     * dentro del polígono.
     *
     * @param points vértices del polígono.
     * @return área máxima encontrada.
     */
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