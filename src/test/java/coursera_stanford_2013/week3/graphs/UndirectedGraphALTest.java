package coursera_stanford_2013.week3.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UndirectedGraphALTest extends AbstractGraphALTest {

    @Before
    public void init() {
        graph = new UndirectedGraphAL();
    }

    @Test
    public void should_contain_edges_between_two_connected_vertices() {
        // given
        int key1 = 1;
        int key2 = 2;

        graph.addVertex(key1);
        graph.addVertex(key2);

        // when
        graph.addEdge(key1, key2);

        // then
        boolean hasEdgeOne = graph.hasEdge(key1, key2);
        boolean hasEdgeTwo = graph.hasEdge(key2, key1);

        assertTrue(hasEdgeOne);
        assertTrue(hasEdgeTwo);
    }

    @Test
    public void should_add_edge_and_create_vertex() {
        // given
        int key1 = 1;
        int key2 = 2;

        // when
        graph.addEdgeAndCreateVertex(key1, key2);

        // then
        boolean hasEdgeOne = graph.hasEdge(key1, key2);
        boolean hasEdgeTwo = graph.hasEdge(key2, key1);

        assertNotNull(graph.getVertex(key1));
        assertNotNull(graph.getVertex(key2));
        assertTrue(hasEdgeOne);
        assertTrue(hasEdgeTwo);
    }
}
