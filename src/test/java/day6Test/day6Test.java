package day6Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.AoC.Diego.day6.WorksheetSolver;

public class day6Test {

    private WorksheetSolver solver;

    @BeforeEach
    public void setUp() {
        this.solver = new WorksheetSolver();
    }

    @Test
    public void testEnunciadoEjemploParte1() {
        String input =
                "123 328  51 64\n" +
                        " 45 64  387 23\n" +
                        "  6 98  215 314\n" +
                        "* +   * +";

        long esperado = 4277556L;
        long actual = solver.solvePart1(input);

        assertEquals(esperado, actual, "La Parte 1 debería dar 4277556");
    }

    @Test
    public void testEnunciadoEjemploParte2() {
        String input =
                "123 328  51 64\n" +
                        " 45 64  387 23\n" +
                        "  6 98  215 314\n" +
                        "* +   * +";

        long esperado = 3263827L;
        long actual = solver.solvePart2(input);

        assertEquals(esperado, actual, "La Parte 2 debería dar 3263827");
    }
}