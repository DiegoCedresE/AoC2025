package com.AoC.Diego.day5;
import java.util.ArrayList;
import java.util.List;
/**
 * Convierte la entrada del problema en los datos necesarios para su procesamiento.
 */
public class InputParser {
    /**
     * Analiza la entrada y extrae los rangos y, si existen, los identificadores.
     *
     * @param input texto de entrada del problema.
     * @return objeto con los rangos y los identificadores obtenidos.
     */
    public ParsedInput parse(String input) {
        List<Range> ranges = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        String[] sections = input.trim().split("\\R\\R");
        // Rangos
        for (String line : sections[0].split("\\R")) {
            String[] values = line.split("-");
            int start = Integer.parseInt(values[0]);
            int end = Integer.parseInt(values[1]);
            ranges.add(new Range(start, end));
        }
        // IDs (solo existen en la parte 1)
        if (sections.length > 1) {
            for (String line : sections[1].split("\\R")) {
                ids.add(Integer.parseInt(line));
            }
        }
        return new ParsedInput(ranges, ids);
    }
}