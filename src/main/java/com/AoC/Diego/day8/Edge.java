package com.AoC.Diego.day8;
/**
 * Representa una conexión entre dos puntos junto con la distancia
 * que los separa.
 */
public class Edge implements Comparable<Edge> {
    private final int from;
    private final int to;
    private final double distance;
    public Edge(int from, int to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    /**
     * Devuelve el índice del punto de origen.
     *
     * @return índice del punto de origen.
     */
    public int getFrom() {
        return from;
    }
    /**
     * Devuelve el índice del punto de destino.
     *
     * @return índice del punto de destino.
     */
    public int getTo() {
        return to;
    }
    /**
     * Devuelve la distancia entre los dos puntos.
     *
     * @return distancia de la conexión.
     */
    public double getDistance() {
        return distance;
    }
    /**
     * Compara dos conexiones según su distancia.
     *
     * @param other conexión con la que se compara.
     * @return valor negativo, cero o positivo según el orden de las distancias.
     */
    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.distance, other.distance);
    }
}