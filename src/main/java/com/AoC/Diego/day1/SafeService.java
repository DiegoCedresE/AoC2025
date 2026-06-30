package com.AoC.Diego.day1;

import java.util.List;

/**
 * Servicio encargado de calcular la contraseña de la caja fuerte
 * a partir de una secuencia de rotaciones.
 */
public class SafeService {

    private static final int MAX = 100;
    private static final int START = 50;

    /**
     * Calcula la contraseña contando únicamente las rotaciones
     * que terminan en la posición 0.
     *
     * @param rotations secuencia de rotaciones del dial.
     * @return número de rotaciones cuya posición final es 0.
     */
    public int getPassword(List<Rotation> rotations) {

        int position = START;
        int password = 0;

        for (Rotation rotation : rotations) {

            position = rotation.getDirection().move(position, rotation.getClicks());

            if (position == 0) {
                password++;
            }
        }

        return password;
    }

    /**
     * Calcula la contraseña contando todas las veces que el dial
     * pasa por la posición 0 durante las rotaciones.
     *
     * @param rotations secuencia de rotaciones del dial.
     * @return número de veces que el dial pasa por la posición 0.
     */
    public int getPasswordMethod2(List<Rotation> rotations) {

        int position = START;
        int password = 0;

        for (Rotation rotation : rotations) {

            for (int i = 0; i < rotation.getClicks(); i++) {

                position = rotation.getDirection().move(position, 1);

                if (position == 0) {
                    password++;
                }
            }
        }

        return password;
    }
}