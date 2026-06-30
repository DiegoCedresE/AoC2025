package com.AoC.Diego.day10;
import java.util.*;

public class Part2Solver implements Solver {

    @Override
    public int solve(Machine machine) {

        int[] objetivo = machine.getTargetJolts();
        List<int[]> botones = machine.getButtons();

        Queue<State> cola = new LinkedList<>();
        Set<String> visitados = new HashSet<>();

        int[] inicio = new int[objetivo.length];

        cola.add(new State(inicio, 0));
        visitados.add(Arrays.toString(inicio));

        while (!cola.isEmpty()) {

            State actual = cola.poll();

            if (Arrays.equals(actual.values, objetivo)) {
                return actual.presses;
            }

            for (int[] boton : botones) {

                int[] siguiente = actual.values.clone();

                boolean valido = true;

                for (int contador : boton) {

                    siguiente[contador]++;

                    if (siguiente[contador] > objetivo[contador]) {
                        valido = false;
                        break;
                    }
                }

                if (!valido) {
                    continue;
                }

                String clave = Arrays.toString(siguiente);

                if (!visitados.contains(clave)) {

                    visitados.add(clave);

                    cola.add(new State(siguiente,
                            actual.presses + 1));
                }
            }
        }

        return -1;
    }
}