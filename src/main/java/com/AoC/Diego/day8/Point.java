package com.AoC.Diego.day8;

public class Point {

    private final int x;
    private final int y;
    private final int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public double distance(Point other) {

        long dx = x - other.x;
        long dy = y - other.y;
        long dz = z - other.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}