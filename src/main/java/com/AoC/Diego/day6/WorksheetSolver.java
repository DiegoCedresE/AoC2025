package com.AoC.Diego.day6;
import java.util.List;

public class WorksheetSolver {

    private final WorksheetParser parser = new WorksheetParser();

    public long solvePart1(String input) {
        return solve(parser.parsePart1(input));
    }

    public long solvePart2(String input) {
        return solve(parser.parsePart2(input));
    }

    private long solve(List<Problem> problems) {

        long total = 0;

        for (Problem p : problems) {

            if (p.getOperation() == '+') {
                long sum = 0;
                for (long n : p.getNumbers()) sum += n;
                total += sum;
            } else {
                long mul = 1;
                for (long n : p.getNumbers()) mul *= n;
                total += mul;
            }
        }

        return total;
    }
}