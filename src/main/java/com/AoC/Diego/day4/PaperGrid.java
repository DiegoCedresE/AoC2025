package com.AoC.Diego.day4;

public class PaperGrid {

    private final char[][] grid;

    public PaperGrid(String input) {
        String[] lines = input.split("\\R");
        grid = new char[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }
    }

    public int rows() {
        return grid.length;
    }

    public int cols() {
        return grid[0].length;
    }

    public boolean isPaper(int r, int c) {
        return inside(r, c) && grid[r][c] == '@';
    }

    public void removePaper(int r, int c) {
        grid[r][c] = '.';
    }

    public boolean inside(int r, int c) {
        return r >= 0 && r < rows() && c >= 0 && c < cols();
    }
}