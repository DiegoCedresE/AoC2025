package com.AoC.Diego.day10;
import java.util.List;
public class Part1Solver implements Solver {

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

                // ¿Se pulsa este botón?
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

    private boolean iguales(boolean[] a, boolean[] b) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}