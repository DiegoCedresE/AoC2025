package com.AoC.Diego.day4;
/**
 * Representa una cuadrícula de papel sobre la que se realizan las operaciones
 * del problema.
 */
public class PaperGrid {
    private final char[][] grid;
    /**
     * Crea la cuadrícula a partir del texto de entrada.
     *
     * @param input representación de la cuadrícula, con una fila por línea.
     */
    public PaperGrid(String input) {
        String[] lines = input.split("\\R");
        grid = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }
    }
    /**
     * Devuelve el número de filas de la cuadrícula.
     */
    public int rows() {
        return grid.length;
    }
    /**
     * Devuelve el número de columnas de la cuadrícula.
     */
    public int cols() {
        return grid[0].length;
    }
    /**
     * Indica si la posición contiene una hoja de papel.
     *
     * @param r fila.
     * @param c columna.
     * @return {@code true} si la posición contiene '@'; {@code false} en caso contrario.
     */
    public boolean isPaper(int r, int c) {
        return inside(r, c) && grid[r][c] == '@';
    }
    /**
     * Elimina la hoja de papel de la posición indicada.
     *
     * @param r fila.
     * @param c columna.
     */
    public void removePaper(int r, int c) {
        grid[r][c] = '.';
    }
    /**
     * Comprueba si una posición pertenece a la cuadrícula.
     *
     * @param r fila.
     * @param c columna.
     * @return {@code true} si la posición es válida; {@code false} en caso contrario.
     */
    public boolean inside(int r, int c) {
        return r >= 0 && r < rows() && c >= 0 && c < cols();
    }
}