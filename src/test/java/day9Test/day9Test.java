package day9Test;

import com.AoC.Diego.day9.Point;
import com.AoC.Diego.day9.RectangleService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class day9Test {

    private final RectangleService service = new RectangleService();

    @Test
    void testPart1Example() {

        List<Point> points = List.of(
                new Point(7,1),
                new Point(11,1),
                new Point(11,7),
                new Point(9,7),
                new Point(9,5),
                new Point(2,5),
                new Point(2,3),
                new Point(7,3)
        );

        assertEquals(50, service.part1(points));
    }

    @Test
    void testPart2Example() {

        List<Point> points = List.of(
                new Point(7,1),
                new Point(11,1),
                new Point(11,7),
                new Point(9,7),
                new Point(9,5),
                new Point(2,5),
                new Point(2,3),
                new Point(7,3)
        );

        assertEquals(24, service.part2(points));
    }

    @Test
    void testRectangleAreaFromTwoCorners() {

        List<Point> points = List.of(
                new Point(2,5),
                new Point(11,1)
        );

        assertEquals(50, service.part1(points));
    }
}