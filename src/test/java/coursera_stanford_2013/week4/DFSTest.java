package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class DFSTest {
    private UndirectedGraphAL graph;

    @Before
    public void setUp() throws Exception {
        graph = new UndirectedGraphAL();
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
