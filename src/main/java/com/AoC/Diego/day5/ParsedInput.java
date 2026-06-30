package com.AoC.Diego.day5;

import java.util.List;

public class ParsedInput {

    private final List<Range> ranges;
    private final List<Integer> ids;

    public ParsedInput(List<Range> ranges, List<Integer> ids) {
        this.ranges = ranges;
        this.ids = ids;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public List<Integer> getIds() {
        return ids;
    }
}