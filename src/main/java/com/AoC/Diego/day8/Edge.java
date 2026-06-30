package com.AoC.Diego.day8;

public class Edge implements Comparable<Edge> {

    private final int from;
    private final int to;
    private final double distance;

    public Edge(int from, int to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.distance, other.distance);
    }
}