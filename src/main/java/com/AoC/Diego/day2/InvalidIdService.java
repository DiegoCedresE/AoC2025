package com.AoC.Diego.day2;

import java.util.ArrayList;
import java.util.List;

public class InvalidIdService {

    private final InvalidRule rule;

    public InvalidIdService(InvalidRule rule) {
        this.rule = rule;
    }

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