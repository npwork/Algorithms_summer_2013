package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BFSTest {


    @Test
    public void containsTestUndirectedGraph_true() throws Exception {
        // given
        UndirectedGraphAL graphAL = initGraph1();
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
        UndirectedGraphAL graphAL = initGraph1();
        int searchVertex = 9;

        // when
        Vertex resultVertex = BFS.isConnected(graphAL, 1, searchVertex);

        // then
        assertNull(resultVertex);
    }

    private UndirectedGraphAL initGraph1() {
        UndirectedGraphAL graphAL = new UndirectedGraphAL();
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(1, 3);
        graphAL.addEdgeAndCreateVertex(1, 4);
        graphAL.addEdgeAndCreateVertex(1, 5);

        graphAL.addEdgeAndCreateVertex(3, 6);
        graphAL.addEdgeAndCreateVertex(2, 7);

        graphAL.addEdgeAndCreateVertex(8, 9);
        return graphAL;
    }

    @Test
    public void should_build_bfs_tree_from_just_three_objects() throws Exception {
        // given
        UndirectedGraphAL graphAL = new UndirectedGraphAL();
        graphAL.addEdgeAndCreateVertex(1,2);
        graphAL.addEdgeAndCreateVertex(2,3);

        // when
        BFSTree bfsTree = BFS.buildBfsTree(graphAL, 1);

        // then
        assertEquals(1, bfsTree.getDistanceTo(2));
        assertEquals(2, bfsTree.getDistanceTo(3));
    }

    private UndirectedGraphAL initGraph2() {
        UndirectedGraphAL graphAL = new UndirectedGraphAL();

        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(2, 3);
        graphAL.addEdgeAndCreateVertex(2, 4);
        graphAL.addEdgeAndCreateVertex(3, 4);
        graphAL.addEdgeAndCreateVertex(3, 5);
        graphAL.addEdgeAndCreateVertex(4, 5);
        graphAL.addEdgeAndCreateVertex(4, 6);
        graphAL.addEdgeAndCreateVertex(5, 6);

        return graphAL;
    }
}
