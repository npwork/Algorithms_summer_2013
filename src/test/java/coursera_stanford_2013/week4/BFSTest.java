package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 16.08.13
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class BFSTest {

    private UndirectedGraphAL graphAL;

    @Before
    public void init() {
        graphAL = new UndirectedGraphAL();
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(1, 3);
        graphAL.addEdgeAndCreateVertex(1, 4);
        graphAL.addEdgeAndCreateVertex(1, 5);

        graphAL.addEdgeAndCreateVertex(3, 6);
        graphAL.addEdgeAndCreateVertex(2, 7);

        graphAL.addEdgeAndCreateVertex(8, 9);
    }

    @Test
    public void containsTestUndirectedGraph_true() throws Exception {
        // given
        int searchVertex = 7;

        // when
        Vertex resultVertex = BFS.isConnected(graphAL, 1, searchVertex);

        // then
        assertNotNull(resultVertex);
        assertEquals(searchVertex, resultVertex.getValue());
    }

    @Test
    public void containsTestUndirectedGraph_false() throws Exception {
        // given
        int searchVertex = 9;

        // when
        Vertex resultVertex = BFS.isConnected(graphAL, 1, searchVertex);

        // then
        assertNull(resultVertex);
    }
}
