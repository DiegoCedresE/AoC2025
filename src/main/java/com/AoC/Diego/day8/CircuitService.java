package com.AoC.Diego.day8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Servicio encargado de resolver las dos partes del problema de conexión
 * de circuitos.
 */
public class CircuitService {
    /**
     * Convierte la entrada en una lista de puntos tridimensionales.
     *
     * @param input líneas con las coordenadas de cada punto.
     * @return lista de puntos.
     */
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
    /**
     * Genera todas las conexiones posibles entre los puntos y las ordena
     * por distancia creciente.
     *
     * @param points lista de puntos.
     * @return lista de conexiones ordenadas.
     */
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
    /**
     * Construye el número de conexiones indicado y devuelve el producto
     * de los tamaños de las tres componentes conexas más grandes.
     *
     * @param input datos de entrada.
     * @param connections número de conexiones que deben realizarse.
     * @return producto de los tamaños de las tres componentes más grandes.
     */
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
    /**
     * Une los puntos hasta formar una única componente conexa y devuelve
     * el producto de las coordenadas X de los dos puntos que completan
     * la última conexión.
     *
     * @param input datos de entrada.
     * @return producto de las coordenadas X de la última conexión.
     */
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