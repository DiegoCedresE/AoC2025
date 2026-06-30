package com.AoC.Diego.day5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Servicio encargado de realizar los cálculos sobre el inventario.
 */
public class InventoryService {
    /**
     * Cuenta cuántos identificadores pertenecen a alguno de los rangos indicados.
     *
     * @param ranges rangos válidos.
     * @param ids identificadores a comprobar.
     * @return número de identificadores que están contenidos en algún rango.
     */
    public int countFresh(List<Range> ranges, List<Integer> ids) {
        int count = 0;
        for (int id : ids) {
            for (Range range : ranges) {
                if (range.contains(id)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    /**
     * Calcula el número total de identificadores cubiertos por los rangos,
     * fusionando previamente los rangos que se solapan o son consecutivos.
     *
     * @param ranges lista de rangos.
     * @return número total de identificadores contenidos en los rangos.
     */
    public int countFreshIds(List<Range> ranges) {
        if (ranges.isEmpty()) {
            return 0;
        }
        List<Range> sortedRanges = new ArrayList<>(ranges);
        sortedRanges.sort(Comparator.comparingInt(Range::getStart));
        int total = 0;
        int start = sortedRanges.get(0).getStart();
        int end = sortedRanges.get(0).getEnd();
        for (int i = 1; i < sortedRanges.size(); i++) {
            Range current = sortedRanges.get(i);
            if (current.getStart() <= end + 1) {
                end = Math.max(end, current.getEnd());
            } else {
                total += end - start + 1;
                start = current.getStart();
                end = current.getEnd();
            }
        }
        total += end - start + 1;
        return total;
    }
}