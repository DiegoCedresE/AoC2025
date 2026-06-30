package day8Test;

import com.AoC.Diego.day8.CircuitService;
import com.AoC.Diego.day8.Edge;
import com.AoC.Diego.day8.Point;
import com.AoC.Diego.day8.UnionFind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircuitServiceTest {

    private CircuitService service;
    private List<String> exampleInput;

    /**
     * Inicializa el servicio y carga el ejemplo oficial del enunciado
     * antes de ejecutar cada prueba.
     */
    @BeforeEach
    void setUp() {
        service = new CircuitService();

        exampleInput = List.of(
                "162,817,812",
                "57,618,57",
                "906,360,560",
                "592,479,940",
                "352,342,300",
                "466,668,158",
                "542,29,236",
                "431,825,988",
                "739,650,466",
                "52,470,668",
                "216,146,977",
                "819,987,18",
                "117,168,530",
                "805,96,715",
                "346,949,466",
                "970,615,88",
                "941,993,340",
                "862,61,35",
                "984,92,344",
                "425,690,689"
        );
    }

    /**
     * Comprueba que la primera parte devuelve el resultado esperado
     * utilizando el ejemplo oficial del enunciado.
     */
    @Test
    void shouldSolveExamplePart1() {
        assertEquals(40, service.solvePart1(exampleInput, 10));
    }

    /**
     * Comprueba que la segunda parte devuelve el resultado esperado
     * utilizando el ejemplo oficial del enunciado.
     */
    @Test
    void shouldSolveExamplePart2() {
        assertEquals(25272, service.solvePart2(exampleInput));
    }

    /**
     * Verifica que la distancia euclídea entre dos puntos
     * se calcula correctamente.
     */
    @Test
    void shouldCalculateDistanceCorrectly() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(3, 4, 0);

        assertEquals(5.0, p1.distance(p2), 0.0001);
    }

    /**
     * Comprueba que las aristas se ordenan correctamente
     * según su distancia.
     */
    @Test
    void shouldCompareEdgesByDistance() {
        Edge e1 = new Edge(0, 1, 5);
        Edge e2 = new Edge(0, 2, 10);

        assertTrue(e1.compareTo(e2) < 0);
    }

    /**
     * Verifica que la operación union conecta correctamente
     * dos nodos diferentes.
     */
    @Test
    void shouldUnionNodes() {
        UnionFind uf = new UnionFind(4);

        assertTrue(uf.union(0, 1));
        assertEquals(2, uf.getSize(0));
    }

    /**
     * Comprueba que no se vuelve a unir un conjunto
     * cuyos nodos ya están conectados.
     */
    @Test
    void shouldNotUnionConnectedNodes() {
        UnionFind uf = new UnionFind(3);

        uf.union(0, 1);

        assertFalse(uf.union(0, 1));
    }

    /**
     * Verifica que el número de conjuntos disminuye
     * después de realizar una unión.
     */
    @Test
    void shouldCountSetsCorrectly() {
        UnionFind uf = new UnionFind(4);

        assertEquals(4, uf.getNumberOfSets());

        uf.union(0, 1);

        assertEquals(3, uf.getNumberOfSets());
    }

    /**
     * Comprueba que el servicio es capaz de procesar
     * una entrada mínima sin lanzar excepciones.
     */
    @Test
    void shouldParseSinglePoint() {
        List<String> input = Collections.singletonList("1,2,3");

        assertDoesNotThrow(() -> service.solvePart2(input));
    }
}