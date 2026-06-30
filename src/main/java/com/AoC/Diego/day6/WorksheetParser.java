package com.AoC.Diego.day6;
import java.util.ArrayList;
import java.util.List;

public class WorksheetParser {

    public List<Problem> parsePart1(String input) {
        return parse(input, false);
    }

    public List<Problem> parsePart2(String input) {
        return parse(input, true);
    }

    private int maxWidth(String[] lines) {
        int max = 0;
        for (String line : lines) {
            max = Math.max(max, line.length());
        }
        return max;
    }

    private boolean isEmpty(String[] lines, int col) {
        for (String line : lines) {
            if (col < line.length() && line.charAt(col) != ' ') {
                return false;
            }
        }
        return true;
    }

    private char readOp(String lastLine, int index) {
        // Buscamos de izquierda a derecha todos los operadores disponibles en la última fila
        List<Character> operators = new ArrayList<>();
        for (int c = 0; c < lastLine.length(); c++) {
            char ch = lastLine.charAt(c);
            if (ch == '+' || ch == '*') {
                operators.add(ch);
            }
        }

        // Si por alguna razón el índice solicitado no existe, lanzamos la excepción
        if (index < operators.size()) {
            return operators.get(index);
        }
        throw new IllegalArgumentException("Operador no encontrado para el bloque " + index);
    }

    private List<Problem> parse(String input, boolean part2) {
        String[] lines = input.split("\\R");
        int width = maxWidth(lines);
        List<Problem> problems = new ArrayList<>();
        int col = 0;
        int problemIndex = 0; // <--- Rastreador secuencial de bloques

        while (col < width) {
            while (col < width && isEmpty(lines, col)) {
                col++;
            }
            if (col >= width) break;
            int start = col;
            while (col < width && !isEmpty(lines, col)) {
                col++;
            }
            int end = col;
            List<Long> numbers = part2
                    ? readPart2(lines, start, end)
                    : readPart1(lines, start, end);

            // Le pasamos la última línea y el número de bloque actual
            char op = readOp(lines[lines.length - 1], problemIndex);
            problems.add(new Problem(numbers, op));

            problemIndex++; // Avanzamos al siguiente bloque
        }
        return problems;
    }

    // ---------------- PARTE 1 ----------------

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

    // ---------------- PARTE 2  ----------------
    private List<Long> readPart2(String[] lines, int start, int end) {

        List<Long> result = new ArrayList<>();
        int rows = lines.length - 1; // Excluimos la fila del operador

        // 1. Recorremos las columnas del bloque de DERECHA a IZQUIERDA
        for (int c = end - 1; c >= start; c--) {

            StringBuilder sb = new StringBuilder();

            // 2. Para cada columna, leemos los dígitos de ARRIBA a ABAJO
            for (int r = 0; r < rows; r++) {
                if (c < lines[r].length()) {
                    char ch = lines[r].charAt(c);
                    if (Character.isDigit(ch)) {
                        sb.append(ch);
                    }
                }
            }

            // 3. Si la columna contenía dígitos, formamos el número
            if (sb.length() > 0) {
                result.add(Long.parseLong(sb.toString()));
            }
        }

        return result;
    }
}