package day10Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.AoC.Diego.day10.Machine;
import com.AoC.Diego.day10.Part1Solver;
import com.AoC.Diego.day10.Part2Solver;
import com.AoC.Diego.day10.Solver;
import org.junit.jupiter.api.Test;

class day10Test {
        @Test
        void testParte1Total() {

            List<Machine> machines = crearMaquinas();

            Solver solver = new Part1Solver();

            int total = 0;

            for (Machine machine : machines) {
                total += solver.solve(machine);
            }

            assertEquals(7, total);
        }

        @Test
        void testParte2Total() {

            List<Machine> machines = crearMaquinas();

            Solver solver = new Part2Solver();

            int total = 0;

            for (Machine machine : machines) {
                total += solver.solve(machine);
            }

            assertEquals(33, total);
        }

        private List<Machine> crearMaquinas() {

            List<Machine> machines = new ArrayList<>();

            // Máquina 1
            machines.add(new Machine(
                    new boolean[]{false, true, true, false},
                    new int[]{3,5,4,7},
                    Arrays.asList(
                            new int[]{3},
                            new int[]{1,3},
                            new int[]{2},
                            new int[]{2,3},
                            new int[]{0,2},
                            new int[]{0,1}
                    )));

            // Máquina 2
            machines.add(new Machine(
                    new boolean[]{false,false,false,true,false},
                    new int[]{7,5,12,7,2},
                    Arrays.asList(
                            new int[]{0,2,3,4},
                            new int[]{2,3},
                            new int[]{0,4},
                            new int[]{0,1,2},
                            new int[]{1,2,3,4}
                    )));

            // Máquina 3
            machines.add(new Machine(
                    new boolean[]{false,true,true,true,false,true},
                    new int[]{10,11,11,5,10,5},
                    Arrays.asList(
                            new int[]{0,1,2,3,4},
                            new int[]{0,3,4},
                            new int[]{0,1,2,4,5},
                            new int[]{1,2}
                    )));

            return machines;
        }
    }