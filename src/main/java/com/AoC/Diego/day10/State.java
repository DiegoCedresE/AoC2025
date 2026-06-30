package com.AoC.Diego.day10;
/**
 * Representa un estado de la búsqueda, formado por los valores
 * actuales de los contadores y el número de pulsaciones realizadas.
 */
public class State {
    int[] values;
    int presses;
    public State(int[] values, int presses) {
        this.values = values;
        this.presses = presses;
    }
}