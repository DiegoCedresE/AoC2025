package day4Test;

import com.AoC.Diego.day4.PaperRollSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class day4Test {

    private static final String EXAMPLE =
            "..@@.@@@@.\n" +
                    "@@@.@.@.@@\n" +
                    "@@@@@.@.@@\n" +
                    "@.@@@@..@.\n" +
                    "@@.@@@@.@@\n" +
                    ".@@@@@@@.@\n" +
                    ".@.@.@.@@@\n" +
                    "@.@@@.@@@@\n" +
                    ".@@@@@@@@.\n" +
                    "@.@.@@@.@.";

    @Test
    void part1Example() {

        PaperRollSolver solver = new PaperRollSolver();

        assertEquals(13, solver.part1(EXAMPLE));
    }

    @Test
    void part2Example() {

        PaperRollSolver solver = new PaperRollSolver();

        assertEquals(43, solver.part2(EXAMPLE));
    }

    @Test
    void emptyGrid() {

        PaperRollSolver solver = new PaperRollSolver();

        assertEquals(0,
                solver.part1("...\n...\n..."));

        assertEquals(0,
                solver.part2("...\n...\n..."));
    }

    @Test
    void singlePaper() {

        PaperRollSolver solver = new PaperRollSolver();

        assertEquals(1, solver.part1("@"));

        assertEquals(1, solver.part2("@"));
    }
}