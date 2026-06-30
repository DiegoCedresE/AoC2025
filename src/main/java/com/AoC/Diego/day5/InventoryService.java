package com.AoC.Diego.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InventoryService {

    // Parte 1
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

    // Parte 2
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