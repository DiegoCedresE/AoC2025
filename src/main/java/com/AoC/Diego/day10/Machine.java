package com.AoC.Diego.day10;

import java.util.List;

public class Machine {

    private final boolean[] targetLights;
    private final int[] targetJolts;
    private final List<int[]> buttons;

    public Machine(boolean[] targetLights, int[] targetJolts, List<int[]> buttons) {
        this.targetLights = targetLights;
        this.targetJolts = targetJolts;
        this.buttons = buttons;
    }

    public boolean[] getTargetLights() {
        return targetLights;
    }

    public int[] getTargetJolts() {
        return targetJolts;
    }

    public List<int[]> getButtons() {
        return buttons;
    }
}