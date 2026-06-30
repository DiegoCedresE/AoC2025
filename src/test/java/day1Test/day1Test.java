package day1Test;


import com.AoC.Diego.day1.Direction;
import com.AoC.Diego.day1.Rotation;
import com.AoC.Diego.day1.SafeService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class day1Test {

    private final SafeService service = new SafeService();

    private final List<Rotation> example = List.of(
            new Rotation(Direction.L, 68),
            new Rotation(Direction.L, 30),
            new Rotation(Direction.R, 48),
            new Rotation(Direction.L, 5),
            new Rotation(Direction.R, 60),
            new Rotation(Direction.L, 55),
            new Rotation(Direction.L, 1),
            new Rotation(Direction.L, 99),
            new Rotation(Direction.R, 14),
            new Rotation(Direction.L, 82)
    );

    // ---------- PARTE 1 ----------

    @Test
    void shouldReturnThreeForPartOne() {
        assertEquals(3, service.getPassword(example));
    }

    @Test
    void shouldReturnOneWhenEndingAtZero() {

        List<Rotation> rotations = List.of(
                new Rotation(Direction.L, 50)
        );

        assertEquals(1, service.getPassword(rotations));
    }

    @Test
    void shouldReturnZeroWhenNeverEndingAtZero() {

        List<Rotation> rotations = List.of(
                new Rotation(Direction.R, 10),
                new Rotation(Direction.R, 20)
        );

        assertEquals(0, service.getPassword(rotations));
    }

    // ---------- PARTE 2 ----------

    @Test
    void shouldReturnSixForPartTwo() {
        assertEquals(6, service.getPasswordMethod2(example));
    }

    @Test
    void shouldCountTenZerosWithOneThousandClicks() {

        List<Rotation> rotations = List.of(
                new Rotation(Direction.R, 1000)
        );

        assertEquals(10, service.getPasswordMethod2(rotations));
    }

    @Test
    void shouldCountOneZeroDuringRotation() {

        List<Rotation> rotations = List.of(
                new Rotation(Direction.R, 60)
        );

        assertEquals(1, service.getPasswordMethod2(rotations));
    }
}