package com.AoC.Diego.day6;
import java.util.List;
/**
 * Resuelve los problemas obtenidos de la hoja de entrada.
 */
public class WorksheetSolver {
    private final WorksheetParser parser = new WorksheetParser();
    /**
     * Resuelve la primera parte del problema.
     *
     * @param input contenido de la hoja.
     * @return resultado total de la primera parte.
     */
    public long solvePart1(String input) {
        return solve(parser.parsePart1(input));
    }
    /**
     * Resuelve la segunda parte del problema.
     *
     * @param input contenido de la hoja.
     * @return resultado total de la segunda parte.
     */
    public long solvePart2(String input) {
        return solve(parser.parsePart2(input));
    }
    /**
     * Resuelve una colección de problemas aplicando la operación
     * correspondiente a cada uno de ellos.
     *
     * @param problems lista de problemas.
     * @return suma de los resultados obtenidos.
     */
    private long solve(List<Problem> problems) {
        long total = 0;
        for (Problem p : problems) {
            if (p.getOperation() == '+') {
                long sum = 0;
                for (long n : p.getNumbers()) {
                    sum += n;
                }
                total += sum;
            } else {
                long mul = 1;
                for (long n : p.getNumbers()) {
                    mul *= n;
                }
                total += mul;
            }
        }
        return total;
    }
}