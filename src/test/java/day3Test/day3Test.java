package day3Test;

import com.AoC.Diego.day3.JoltageCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class day3Test {

    private final JoltageCalculator calculator = new JoltageCalculator();

    private final String INPUT = """
            987654321111111
            811111111111119
            234234234234278
            818181911112111
            """;

    @Test
    void shouldCalculatePart1Example() {

        long result = calculator.calculatePart1(INPUT);

        assertEquals(357, result);
    }

    @Test
    void shouldCalculatePart2Example() {

        long result = calculator.calculatePart2(INPUT);

        assertEquals(3121910778619L, result);
    }

}