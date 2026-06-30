package com.AoC.Diego.day7;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TachyonSolver {

    private final char[][] board;
    private final int rows;
    private final int cols;

    public TachyonSolver(String input) {

        String[] lines = input.strip().split("\n");

        rows = lines.length;
        cols = lines[0].length();

        board = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            board[i] = lines[i].toCharArray();
        }
    }

    public int countSplits() {

        Queue<Beam> queue = new LinkedList<>();

        int startCol = findStart();

        queue.add(new Beam(1, startCol));

        int splits = 0;

        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {

            Beam beam = queue.poll();

            int row = beam.row;
            int col = beam.col;

            while (row < rows && col >= 0 && col < cols) {

                String key = row + "," + col;

                if (!visited.add(key)) {
                    break;
                }

                if (board[row][col] == '^') {

                    splits++;

                    queue.add(new Beam(row, col - 1));
                    queue.add(new Beam(row, col + 1));

                    break;
                }

                row++;
            }
        }

        return splits;
    }

    public long countTimelines() {

        Queue<BeamState> queue = new LinkedList<>();

        int startCol = findStart();

        queue.add(new BeamState(1, startCol, 1));

        long timelines = 0;

        while (!queue.isEmpty()) {

            BeamState beam = queue.poll();

            int row = beam.row;
            int col = beam.col;
            long ways = beam.timelines;

            while (row < rows && col >= 0 && col < cols) {

                if (board[row][col] == '^') {

                    queue.add(new BeamState(row, col - 1, ways));
                    queue.add(new BeamState(row, col + 1, ways));

                    ways = 0;
                    break;
                }

                row++;
            }

            if (ways > 0) {
                timelines += ways;
            }
        }

        return timelines;
    }

    private int findStart() {

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'S') {
                return c;
            }
        }

        throw new IllegalArgumentException("No se encontró la S.");
    }

    private static class Beam {

        int row;
        int col;

        Beam(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static class BeamState {

        int row;
        int col;
        long timelines;

        BeamState(int row, int col, long timelines) {
            this.row = row;
            this.col = col;
            this.timelines = timelines;
        }
    }
}