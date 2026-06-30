package com.AoC.Diego.day8;
/**
 * Representa un punto en un espacio tridimensional.
 */
public class Point {
    private final int x;
    private final int y;
    private final int z;
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    /**
     * Devuelve la coordenada X del punto.
     *
     * @return coordenada X.
     */
    public int getX() {
        return x;
    }
    /**
     * Calcula la distancia euclídea entre este punto y otro.
     *
     * @param other punto con el que se calcula la distancia.
     * @return distancia entre ambos puntos.
     */
    public double distance(Point other) {
        long dx = x - other.x;
        long dy = y - other.y;
        long dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}