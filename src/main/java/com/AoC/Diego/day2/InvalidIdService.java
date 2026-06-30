package com.AoC.Diego.day2;
import java.util.ArrayList;
import java.util.List;
/**
 * Servicio encargado de calcular la suma de los identificadores
 * que incumplen la regla configurada.
 */
public class InvalidIdService {
    private final InvalidRule rule;
    public InvalidIdService(InvalidRule rule) {
        this.rule = rule;
    }
    /**
     * Calcula la suma de todos los identificadores inválidos
     * contenidos en los rangos de entrada.
     *
     * @param input rangos de identificadores en formato "inicio-fin", separados por comas.
     * @return suma de los identificadores inválidos.
     */
    public long sumInvalidIds(String input) {
        List<Range> ranges = parseRanges(input);
        long sum = 0;
        for (Range range : ranges) {
            for (long id = range.getStart(); id <= range.getEnd(); id++) {
                if (rule.isInvalid(id)) {
                    sum += id;
                }
            }
        }
        return sum;
    }
    /**
     * Convierte la cadena de entrada en una lista de rangos.
     *
     * @param input rangos en formato "inicio-fin", separados por comas.
     * @return lista de rangos obtenidos de la entrada.
     */
    private List<Range> parseRanges(String input) {
        List<Range> ranges = new ArrayList<>();
        String[] tokens = input.split(",");
        for (String token : tokens) {
            String[] values = token.split("-");
            long start = Long.parseLong(values[0]);
            long end = Long.parseLong(values[1]);
            ranges.add(new Range(start, end));
        }
        return ranges;
    }
}