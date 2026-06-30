package com.AoC.Diego.day1;

import java.util.List;

public class SafeService {

    private static final int MAX = 100;
    private static final int START = 50;

    // ---------- PARTE 1 ----------
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

    // ---------- PARTE 2 ----------
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