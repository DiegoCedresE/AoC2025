package com.AoC.Diego.day3;

public class JoltageStrategy {

    /**
     * Parte 1:
     * Escoge exactamente 2 dígitos manteniendo el orden.
     */
    public long calculateTwo(String bank) {

        int max = 0;

        for (int i = 0; i < bank.length() - 1; i++) {
            for (int j = i + 1; j < bank.length(); j++) {

                int value = Integer.parseInt("" + bank.charAt(i) + bank.charAt(j));

                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }

    /**
     * Parte 2:
     * Escoge exactamente 12 dígitos manteniendo el orden.
     * Algoritmo greedy clásico para obtener el mayor número posible.
     */
    public long calculateTwelve(String bank) {

        int k = 12;

        StringBuilder result = new StringBuilder();

        int start = 0;

        while (k > 0) {

            int bestIndex = start;

            for (int i = start; i <= bank.length() - k; i++) {

                if (bank.charAt(i) > bank.charAt(bestIndex)) {
                    bestIndex = i;
                }
            }

            result.append(bank.charAt(bestIndex));
            start = bestIndex + 1;
            k--;
        }

        return Long.parseLong(result.toString());
    }
}