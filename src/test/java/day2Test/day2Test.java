package day2Test;

import com.AoC.Diego.day2.InvalidIdService;
import com.AoC.Diego.day2.RepeatedPatternRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class day2Test {

    private final InvalidIdService part1 =
            new InvalidIdService(
                    new RepeatedPatternRule(RepeatedPatternRule.Mode.PART1));

    private final InvalidIdService part2 =
            new InvalidIdService(
                    new RepeatedPatternRule(RepeatedPatternRule.Mode.PART2));

    private final String input =
            "11-22," +
                    "95-115," +
                    "998-1012," +
                    "1188511880-1188511890," +
                    "222220-222224," +
                    "1698522-1698528," +
                    "446443-446449," +
                    "38593856-38593862," +
                    "565653-565659," +
                    "824824821-824824827," +
                    "2121212118-2121212124";

    // -------- PARTE 1 --------

    @Test
    void testExamplePart1() {
        assertEquals(1227775554L, part1.sumInvalidIds(input));
    }

    @Test
    void testRange11to22Part1() {
        assertEquals(33, part1.sumInvalidIds("11-22"));
    }

    @Test
    void testRange95to115Part1() {
        assertEquals(99, part1.sumInvalidIds("95-115"));
    }

    // -------- PARTE 2 --------

    @Test
    void testExamplePart2() {
        assertEquals(4174379265L, part2.sumInvalidIds(input));
    }

    @Test
    void testRange95to115Part2() {
        assertEquals(210, part2.sumInvalidIds("95-115"));
    }

    @Test
    void testRange998to1012Part2() {
        assertEquals(2009, part2.sumInvalidIds("998-1012"));
    }

}