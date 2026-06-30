package com.AoC.Diego.day5;
import java.util.List;
/**
 * Contiene los datos obtenidos tras analizar la entrada del problema.
 */
public class ParsedInput {
    private final List<Range> ranges;
    private final List<Integer> ids;
    public ParsedInput(List<Range> ranges, List<Integer> ids) {
        this.ranges = ranges;
        this.ids = ids;
    }
    /**
     * Devuelve los rangos extraídos de la entrada.
     *
     * @return lista de rangos.
     */
    public List<Range> getRanges() {
        return ranges;
    }
    /**
     * Devuelve los identificadores extraídos de la entrada.
     *
     * @return lista de identificadores.
     */
    public List<Integer> getIds() {
        return ids;
    }
}