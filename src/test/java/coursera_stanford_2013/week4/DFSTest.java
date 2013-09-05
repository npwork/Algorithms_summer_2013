package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DFSTest extends AbstractGraphSearchTest {
    private GraphAL graph;

    public DFSTest(GraphAL graph) {
        this.graph = graph;
    }

    @Before
    public void setUp() throws Exception {
        graph.deleteAllVerticesAndEdges();
    }

    @Test
    public void should_compute_forest_without_elements() throws Exception {
        // given

        // when
        DFSForest forest = new DFS(graph).computeForest();

        // then
        assertFalse(forest.containsVertex(1));
        assertNull(forest.getParent(1));
    }

    @Test
    public void should_compute_forest_from_one_object() throws Exception {
        // given
        graph.addVertex(1);

        // when
        DFSForest forest = new DFS(graph).computeForest();

        // then
        assertTrue(forest.containsVertex(1));
        assertNull(forest.getParent(1));
    }

    @Test
    public void should_compute_forest_from_two_connected_object() throws Exception {
        // given
        graph.addEdgeAndCreateVertex(1, 2);

        // when
        DFSForest forest = new DFS(graph).computeForest();

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
        DFSForest forest = new DFS(graph).computeForest();

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
        DFSForest forest = new DFS(graph).computeForest();

        // then
        assertStartTimeForFourVerticesInaRow(forest);
        assertStopTimeForFourVerticesInaRow(forest);
    }

    @Test
    public void should_compute_topological_sorted_dag() throws Exception {
        // given
        graph.addEdgeAndCreateVertex(1, 2);
        graph.addEdgeAndCreateVertex(2, 3);
        graph.addEdgeAndCreateVertex(3, 4);

        // when
        List<Vertex> topologicallySortedDAG = new DFS(graph).topologicalSort();

        // then
        assertEquals(4, topologicallySortedDAG.size());

        assertEquals(4, topologicallySortedDAG.get(0).getValue());
        assertEquals(3, topologicallySortedDAG.get(1).getValue());
        assertEquals(2, topologicallySortedDAG.get(2).getValue());
        assertEquals(1, topologicallySortedDAG.get(3).getValue());
    }

    private void assertStartTimeForFourVerticesInaRow(DFSForest forest) {
        assertEquals(1, forest.getStartTime(1));
        assertEquals(2, forest.getStartTime(2));
        assertEquals(3, forest.getStartTime(3));
        assertEquals(4, forest.getStartTime(4));
    }

    private void assertStopTimeForFourVerticesInaRow(DFSForest forest) {
        assertEquals(5, forest.getStopTime(4));
        assertEquals(6, forest.getStopTime(3));
        assertEquals(7, forest.getStopTime(2));
        assertEquals(8, forest.getStopTime(1));
    }

    private void assertAllElementsConnected(DFSForest forest) {
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
