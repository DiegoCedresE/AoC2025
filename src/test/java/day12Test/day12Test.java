package day12Test;

import com.AoC.Diego.day12.Board;
import com.AoC.Diego.day12.Point;
import com.AoC.Diego.day12.PuzzleSolver;
import com.AoC.Diego.day12.Shape;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class day12Test {

    private Shape shape(List<int[]> coords) {
        List<Point> points = new ArrayList<>();
        for (int[] c : coords) {
            points.add(new Point(c[0], c[1]));
        }
        return new Shape(points);
    }

    @Test
    void shouldFitSimpleCase() {
        Board board = new Board(4, 4);

        Shape square = shape(List.of(
                new int[]{0,0}, new int[]{1,0},
                new int[]{0,1}, new int[]{1,1}
        ));

        Map<Shape, Integer> req = new HashMap<>();
        req.put(square, 2);

        PuzzleSolver solver = new PuzzleSolver();

        assertTrue(solver.canFit(board, req));
    }

    @Test
    void shouldNotFitImpossibleCase() {
        Board board = new Board(3, 3);

        Shape big = shape(List.of(
                new int[]{0,0}, new int[]{1,0}, new int[]{2,0},
                new int[]{0,1}, new int[]{1,1}, new int[]{2,1}
        ));

        Map<Shape, Integer> req = new HashMap<>();
        req.put(big, 2);

        PuzzleSolver solver = new PuzzleSolver();

        assertFalse(solver.canFit(board, req));
    }
}