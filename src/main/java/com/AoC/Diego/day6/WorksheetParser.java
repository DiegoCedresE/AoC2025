package com.AoC.Diego.day6;
import java.util.ArrayList;
import java.util.List;
/**
 * Analiza la hoja de entrada y la convierte en una lista de problemas.
 */
public class WorksheetParser {
    /**
     * Analiza la entrada con el formato de la primera parte.
     *
     * @param input contenido de la hoja.
     * @return lista de problemas obtenidos.
     */
    public List<Problem> parsePart1(String input) {
        return parse(input, false);
    }
    /**
     * Analiza la entrada con el formato de la segunda parte.
     *
     * @param input contenido de la hoja.
     * @return lista de problemas obtenidos.
     */
    public List<Problem> parsePart2(String input) {
        return parse(input, true);
    }
    /**
     * Obtiene la longitud de la línea más larga.
     */
    private int maxWidth(String[] lines) {
        int max = 0;
        for (String line : lines) {
            max = Math.max(max, line.length());
        }
        return max;
    }
    /**
     * Comprueba si una columna está vacía en todas las filas.
     */
    private boolean isEmpty(String[] lines, int col) {
        for (String line : lines) {
            if (col < line.length() && line.charAt(col) != ' ') {
                return false;
            }
        }
        return true;
    }
    /**
     * Obtiene el operador asociado a un bloque de la hoja.
     */
    private char readOp(String lastLine, int index) {
        List<Character> operators = new ArrayList<>();
        for (int c = 0; c < lastLine.length(); c++) {
            char ch = lastLine.charAt(c);
            if (ch == '+' || ch == '*') {
                operators.add(ch);
            }
        }
        if (index < operators.size()) {
            return operators.get(index);
        }
        throw new IllegalArgumentException("Operador no encontrado para el bloque " + index);
    }
    /**
     * Convierte la entrada en una lista de problemas.
     */
    private List<Problem> parse(String input, boolean part2) {
        String[] lines = input.split("\\R");
        int width = maxWidth(lines);
        List<Problem> problems = new ArrayList<>();
        int col = 0;
        int problemIndex = 0;
        while (col < width) {
            while (col < width && isEmpty(lines, col)) {
                col++;
            }
            if (col >= width) {
                break;
            }
            int start = col;
            while (col < width && !isEmpty(lines, col)) {
                col++;
            }
            int end = col;
            List<Long> numbers = part2
                    ? readPart2(lines, start, end)
                    : readPart1(lines, start, end);
            char op = readOp(lines[lines.length - 1], problemIndex);
            problems.add(new Problem(numbers, op));
            problemIndex++;
        }
        return problems;
    }
    /**
     * Extrae los números de un bloque utilizando el formato de la primera parte.
     */
    private List<Long> readPart1(String[] lines, int start, int end) {
        List<Long> nums = new ArrayList<>();
        for (int r = 0; r < lines.length - 1; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = start; c < end; c++) {
                if (c < lines[r].length() && Character.isDigit(lines[r].charAt(c))) {
                    sb.append(lines[r].charAt(c));
                }
            }
            if (sb.length() > 0) {
                nums.add(Long.parseLong(sb.toString()));
            }
        }
        return nums;
    }
    /**
     * Extrae los números de un bloque utilizando el formato de la segunda parte.
     */
    private List<Long> readPart2(String[] lines, int start, int end) {
        List<Long> result = new ArrayList<>();
        int rows = lines.length - 1;
        for (int c = end - 1; c >= start; c--) {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < rows; r++) {
                if (c < lines[r].length()) {
                    char ch = lines[r].charAt(c);
                    if (Character.isDigit(ch)) {
                        sb.append(ch);
                    }
                }
            }
            if (sb.length() > 0) {
                result.add(Long.parseLong(sb.toString()));
            }
        }
        return result;
    }
}