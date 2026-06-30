package com.AoC.Diego.day3;
/**
 * Servicio encargado de calcular la energía total obtenida
 * a partir de los bancos de adaptadores de entrada.
 */
public class JoltageCalculator {
    private final JoltageStrategy strategy = new JoltageStrategy();
    /**
     * Calcula el resultado de la primera parte utilizando
     * la estrategia correspondiente para cada banco.
     *
     * @param input bancos de adaptadores, uno por línea.
     * @return suma de los resultados obtenidos para todos los bancos.
     */
    public long calculatePart1(String input) {
        long total = 0;
        String[] banks = input.strip().split("\\R");
        for (String bank : banks) {
            total += strategy.calculateTwo(bank);
        }
        return total;
    }
    /**
     * Calcula el resultado de la segunda parte utilizando
     * la estrategia correspondiente para cada banco.
     *
     * @param input bancos de adaptadores, uno por línea.
     * @return suma de los resultados obtenidos para todos los bancos.
     */
    public long calculatePart2(String input) {
        long total = 0;
        String[] banks = input.strip().split("\\R");
        for (String bank : banks) {
            total += strategy.calculateTwelve(bank);
        }
        return total;
    }
}