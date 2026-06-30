package com.AoC.Diego.day5;
/**
 * Representa un rango de valores enteros.
 */
public class Range {
    private final int start;
    private final int end;
    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
    /**
     * Comprueba si un valor pertenece al rango.
     *
     * @param value valor a comprobar.
     * @return {@code true} si el valor está dentro del rango; {@code false} en caso contrario.
     */
    public boolean contains(int value) {
        return value >= start && value <= end;
    }
    /**
     * Devuelve el inicio del rango.
     *
     * @return valor inicial.
     */
    public int getStart() {
        return start;
    }
    /**
     * Devuelve el final del rango.
     *
     * @return valor final.
     */
    public int getEnd() {
        return end;
    }
}