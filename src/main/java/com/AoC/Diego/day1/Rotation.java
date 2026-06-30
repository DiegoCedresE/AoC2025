package com.AoC.Diego.day1;


public class Rotation {

    private final Direction direction;
    private final int clicks;

    public Rotation(Direction direction, int clicks) {
        this.direction = direction;
        this.clicks = clicks;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getClicks() {
        return clicks;
    }
}