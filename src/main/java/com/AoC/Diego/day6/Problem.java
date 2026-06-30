package com.AoC.Diego.day6;
import java.util.List;
/**
 * Representa un problema compuesto por una lista de números
 * y la operación que debe aplicarse sobre ellos.
 */
public class Problem {
    private final List<Long> numbers;
    private final char operation;
    public Problem(List<Long> numbers, char operation) {
        this.numbers = numbers;
        this.operation = operation;
    }
    /**
     * Devuelve los números del problema.
     *
     * @return lista de números.
     */
    public List<Long> getNumbers() {
        return numbers;
    }
    /**
     * Devuelve la operación asociada al problema.
     *
     * @return operación a realizar.
     */
    public char getOperation() {
        return operation;
    }
}