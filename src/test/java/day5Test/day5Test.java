package day5Test;

import com.AoC.Diego.day5.InventoryService;
import com.AoC.Diego.day5.Range;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class day5Test {

    private final InventoryService service = new InventoryService();

    @Test
    void partOneExample() {

        List<Range> ranges = List.of(
                new Range(3, 5),
                new Range(10, 14),
                new Range(16, 20),
                new Range(12, 18)
        );

        List<Integer> ids = List.of(1, 5, 8, 11, 17, 32);

        assertEquals(3, service.countFresh(ranges, ids));
    }

    @Test
    void partTwoExample() {

        List<Range> ranges = List.of(
                new Range(3, 5),
                new Range(10, 14),
                new Range(16, 20),
                new Range(12, 18)
        );

        assertEquals(14, service.countFreshIds(ranges));
    }

    @Test
    void emptyRanges() {
        assertEquals(0, service.countFreshIds(List.of()));
    }

    @Test
    void oneRange() {
        assertEquals(5, service.countFreshIds(List.of(new Range(1, 5))));
    }

    @Test
    void overlappingRanges() {
        List<Range> ranges = List.of(
                new Range(1, 5),
                new Range(3, 8)
        );

        assertEquals(8, service.countFreshIds(ranges));
    }
}