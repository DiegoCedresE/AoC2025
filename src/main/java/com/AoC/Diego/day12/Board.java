package com.AoC.Diego.day12;

import java.util.List;

public class Board {
    private final int width;
    private final int height;
    private final boolean[][] grid;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[height][width];
    }

    public boolean canPlace(List<Point> shape, int offsetX, int offsetY) {
        for (Point p : shape) {
            int x = p.x() + offsetX;
            int y = p.y() + offsetY;

            if (x < 0 || y < 0 || x >= width || y >= height) return false;
            if (grid[y][x]) return false;
        }
        return true;
    }

    public void place(List<Point> shape, int offsetX, int offsetY, boolean value) {
        for (Point p : shape) {
            grid[p.y() + offsetY][p.x() + offsetX] = value;
        }
    }
}