package com.AoC.Diego.day4;

import java.util.ArrayList;
import java.util.List;

public class PaperRollSolver {

    private static final int[] DR = {-1,-1,-1,0,0,1,1,1};
    private static final int[] DC = {-1,0,1,-1,1,-1,0,1};

    public int part1(String input) {

        PaperGrid grid = new PaperGrid(input);

        int count = 0;

        for (int r = 0; r < grid.rows(); r++) {
            for (int c = 0; c < grid.cols(); c++) {

                if (canRemove(grid, r, c)) {
                    count++;
                }
            }
        }

        return count;
    }

    public int part2(String input) {

        PaperGrid grid = new PaperGrid(input);

        int removed = 0;

        while (true) {

            List<int[]> removable = new ArrayList<>();

            for (int r = 0; r < grid.rows(); r++) {
                for (int c = 0; c < grid.cols(); c++) {

                    if (canRemove(grid, r, c)) {
                        removable.add(new int[]{r,c});
                    }
                }
            }

            if (removable.isEmpty()) {
                break;
            }

            for (int[] pos : removable) {
                grid.removePaper(pos[0], pos[1]);
                removed++;
            }
        }

        return removed;
    }

    private boolean canRemove(PaperGrid grid, int r, int c) {

        if (!grid.isPaper(r, c))
            return false;

        int neighbours = 0;

        for (int i = 0; i < 8; i++) {

            int nr = r + DR[i];
            int nc = c + DC[i];

            if (grid.isPaper(nr, nc)) {
                neighbours++;
            }
        }

        return neighbours < 4;
    }
}