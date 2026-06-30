package com.AoC.Diego.day10;
import java.util.List;
/**
 * Resuelve la primera parte del problema buscando la combinación
 * mínima de pulsaciones que alcanza el estado objetivo.
 */
public class Part1Solver implements Solver {
    /**
     * Calcula el número mínimo de botones que deben pulsarse para
     * obtener la configuración objetivo de las luces.
     *
     * @param machine máquina que contiene la configuración objetivo y los botones.
     * @return número mínimo de pulsaciones necesarias.
     */
    @Override
    public int solve(Machine machine) {
        boolean[] objetivo = machine.getTargetLights();
        List<int[]> botones = machine.getButtons();
        int nBotones = botones.size();
        int nLuces = objetivo.length;
        int mejor = Integer.MAX_VALUE;
        // Recorre todas las combinaciones de botones
        for (int mascara = 0; mascara < (1 << nBotones); mascara++) {
            boolean[] estado = new boolean[nLuces];
            int pulsaciones = 0;
            for (int b = 0; b < nBotones; b++) {
                if ((mascara & (1 << b)) != 0) {
                    pulsaciones++;
                    for (int luz : botones.get(b)) {
                        estado[luz] = !estado[luz];
                    }
                }
            }
            if (iguales(estado, objetivo)) {
                mejor = Math.min(mejor, pulsaciones);
            }
        }
        return mejor;
    }
    /**
     * Comprueba si dos configuraciones de luces son iguales.
     *
     * @param a primera configuración.
     * @param b segunda configuración.
     * @return {@code true} si ambas configuraciones coinciden.
     */
    private boolean iguales(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}