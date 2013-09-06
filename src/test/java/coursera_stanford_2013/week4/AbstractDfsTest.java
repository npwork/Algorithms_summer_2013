package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractDfsTest extends AbstractGraphTest {
    protected GraphAL graph;

    protected abstract Forest computeForest();

    @Before
    public void setUp() throws Exception {
        graph.deleteAllVerticesAndEdges();
    }

    @Test
    public void should_compute_forest_without_elements() throws Exception {
        // given

        // when
        Forest forest = computeForest();

        // then
        assertFalse(forest.containsVertex(1));
        assertNull(forest.getParent(1));
    }

    @Test
    public void should_compute_forest_from_one_object() throws Exception {
        // given
        graph.addVertex(1);

        // when
        Forest forest = computeForest();

        // then
        assertTrue(forest.containsVertex(1));
        assertNull(forest.getParent(1));
    }

    @Test
    public void should_compute_forest_from_two_connected_object() throws Exception {
        // given
        graph.addEdgeAndCreateVertex(1, 2);

        // when
        Forest forest = computeForest();

        // then
        assertTrue(forest.containsVertex(1));
        assertTrue(forest.containsVertex(2));
        assertNull(forest.getParent(1));
        assertEquals(1, forest.getParent(2).getValue());
    }

    @Test
    public void should_compute_forest_from_many_connected_objects() throws Exception {
        // given
        graph.addEdgeAndCreateVertex(1, 2);
        graph.addEdgeAndCreateVertex(2, 3);
        graph.addEdgeAndCreateVertex(3, 4);
        graph.addEdgeAndCreateVertex(2, 4);

        // when
        Forest forest = computeForest();

        // then
        assertAllElementsConnected(forest);
    }

    @Test
    public void should_compute_forest_with_valid_start_and_end_time() throws Exception {
        // given
        graph.addEdgeAndCreateVertex(1, 2);
        graph.addEdgeAndCreateVertex(2, 3);
        graph.addEdgeAndCreateVertex(3, 4);

        // when
        Forest forest = computeForest();

        // then
        assertStartTimeForFourVerticesInaRow(forest);
        assertStopTimeForFourVerticesInaRow(forest);
    }

    private void assertStartTimeForFourVerticesInaRow(Forest forest) {
        assertEquals(1, forest.getStartTime(1));
        assertEquals(2, forest.getStartTime(2));
        assertEquals(3, forest.getStartTime(3));
        assertEquals(4, forest.getStartTime(4));
    }

    private void assertStopTimeForFourVerticesInaRow(Forest forest) {
        assertEquals(5, forest.getStopTime(4));
        assertEquals(6, forest.getStopTime(3));
        assertEquals(7, forest.getStopTime(2));
        assertEquals(8, forest.getStopTime(1));
    }

    private void assertAllElementsConnected(Forest forest) {
        assertTrue(forest.containsVertex(1));
        assertTrue(forest.containsVertex(2));
        assertTrue(forest.containsVertex(3));
        assertTrue(forest.containsVertex(4));
        assertNull(forest.getParent(1));
        assertEquals(1, forest.getParent(2).getValue());
        assertEquals(2, forest.getParent(3).getValue());
        assertEquals(3, forest.getParent(4).getValue());
    }
}
