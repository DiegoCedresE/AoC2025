package day11Test;

import com.AoC.Diego.day11.Graph;
import com.AoC.Diego.day11.GraphParser;
import com.AoC.Diego.day11.PathFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class day11Test {

    @Test
    void testPart1_example() {

        String input = """
                aaa: you hhh
                you: bbb ccc
                bbb: ddd eee
                ccc: ddd eee fff
                ddd: ggg
                eee: out
                fff: out
                ggg: out
                hhh: ccc fff iii
                iii: out
                """;

        Graph graph = new GraphParser().parse(input);
        PathFinder finder = new PathFinder();

        int result = finder.countPaths(graph, "you", "out");

        assertEquals(5, result);
    }

    @Test
    void testPart2_example() {

        String input = """
                svr: aaa bbb
                aaa: fft
                fft: ccc
                bbb: tty
                tty: ccc
                ccc: ddd eee
                ddd: hub
                hub: fff
                eee: dac
                dac: fff
                fff: ggg hhh
                ggg: out
                hhh: out
                """;

        Graph graph = new GraphParser().parse(input);
        PathFinder finder = new PathFinder();

        int result = finder.countPathsPassingThrough(
                graph,
                "svr",
                "out",
                "dac",
                "fft"
        );

        assertEquals(2, result);
    }
}