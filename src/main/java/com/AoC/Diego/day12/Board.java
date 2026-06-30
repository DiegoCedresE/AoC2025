package com.AoC.Diego.day12;
import java.util.List;
/**
 * Representa el tablero sobre el que se colocan las piezas.
 */
public class Board {
    private final int width;
    private final int height;
    private final boolean[][] grid;
    /**
     * Crea un tablero con las dimensiones indicadas.
     *
     * @param width ancho del tablero.
     * @param height alto del tablero.
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[height][width];
    }
    /**
     * Comprueba si una pieza puede colocarse en una posición del tablero
     * sin salirse de sus límites ni solaparse con otras piezas.
     *
     * @param shape puntos que forman la pieza.
     * @param offsetX desplazamiento horizontal.
     * @param offsetY desplazamiento vertical.
     * @return {@code true} si la pieza puede colocarse; {@code false} en caso contrario.
     */
    public boolean canPlace(List<Point> shape, int offsetX, int offsetY) {
        for (Point p : shape) {
            int x = p.x() + offsetX;
            int y = p.y() + offsetY;
            if (x < 0 || y < 0 || x >= width || y >= height) {
                return false;
            }
            if (grid[y][x]) {
                return false;
            }
        }
        return true;
    }
    /**
     * Coloca o retira una pieza del tablero.
     *
     * @param shape puntos que forman la pieza.
     * @param offsetX desplazamiento horizontal.
     * @param offsetY desplazamiento vertical.
     * @param value {@code true} para colocar la pieza o {@code false} para retirarla.
     */
    public void place(List<Point> shape, int offsetX, int offsetY, boolean value) {
        for (Point p : shape) {
            grid[p.y() + offsetY][p.x() + offsetX] = value;
        }
    }
}