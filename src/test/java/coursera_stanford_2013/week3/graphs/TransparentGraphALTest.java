package coursera_stanford_2013.week3.graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TransparentGraphALTest {
    private GraphAL graphAL;

    @Before
    public void setUp() throws Exception {
        graphAL = new UndirectedGraphAL();
    }

    @Test
    public void should_leave_graph_the_same_if_no_edges() throws Exception {
        // given
        graphAL.addVertex(1);
        graphAL.addVertex(2);
        graphAL.addVertex(3);

        // when
        GraphAL transparentGraphAL = TransparentGraphAL.transparent(graphAL);

        // then
        assertEquals(3, transparentGraphAL.vertexSize());
        assertEquals(0, transparentGraphAL.edgeSize());
    }

    @Test
    public void should_transparent_graph_with_one_edge() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);

        // when
        GraphAL transparentGraphAL = TransparentGraphAL.transparent(graphAL);

        // then
        Edge transparentEdge = transparentGraphAL.getEdges().get(0);
        assertEquals(2, transparentEdge.getFrom());
        assertEquals(1, transparentEdge.getTo());
    }

    @Test
    public void should_transparent_graph_with_two_edges() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(2, 3);

        // when
        GraphAL transparentGraphAL = TransparentGraphAL.transparent(graphAL);

        // then
        List<Edge> edgesFromTransparentGraph = transparentGraphAL.getEdges();
        assertEquals(2, edgesFromTransparentGraph.size());
        assertHasEdge(edgesFromTransparentGraph, 3, 2);
        assertHasEdge(edgesFromTransparentGraph, 2, 1);
    }

    @Test
    public void should_transparent_cyclic_graph() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(2, 3);
        graphAL.addEdgeAndCreateVertex(3, 1);

        // when
        GraphAL transparentGraphAL = TransparentGraphAL.transparent(graphAL);

        // then
        List<Edge> edgesFromTransparentGraph = transparentGraphAL.getEdges();
        assertEquals(3, edgesFromTransparentGraph.size());
        assertHasEdge(edgesFromTransparentGraph, 3, 2);
        assertHasEdge(edgesFromTransparentGraph, 2, 1);
        assertHasEdge(edgesFromTransparentGraph, 1, 3);
    }

    private void assertHasEdge(List<Edge> edgesFromTransparentGraph, int from, int to) {
        boolean containsEdge = edgesFromTransparentGraph.contains(new Edge(from, to));
        assertTrue(containsEdge);
    }
}
