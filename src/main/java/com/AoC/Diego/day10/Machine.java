package com.AoC.Diego.day10;
import java.util.List;
/**
 * Representa una máquina con su configuración objetivo y los botones
 * disponibles para modificar su estado.
 */
public class Machine {
    private final boolean[] targetLights;
    private final int[] targetJolts;
    private final List<int[]> buttons;
    public Machine(boolean[] targetLights, int[] targetJolts, List<int[]> buttons) {
        this.targetLights = targetLights;
        this.targetJolts = targetJolts;
        this.buttons = buttons;
    }
    /**
     * Devuelve el estado objetivo de las luces.
     *
     * @return estado objetivo de las luces.
     */
    public boolean[] getTargetLights() {
        return targetLights;
    }
    /**
     * Devuelve los valores objetivo de los voltajes.
     *
     * @return valores objetivo de los voltajes.
     */
    public int[] getTargetJolts() {
        return targetJolts;
    }
    /**
     * Devuelve la lista de botones de la máquina.
     *
     * @return botones disponibles.
     */
    public List<int[]> getButtons() {
        return buttons;
    }
}