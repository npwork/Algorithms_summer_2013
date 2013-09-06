package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

@RunWith(value = Parameterized.class)
public class BFSTest extends AbstractGraphTest {
    private GraphAL graphAL;

    public BFSTest(GraphAL graphAL) {
        this.graphAL = graphAL;
    }

    @Before
    public void setUp() throws Exception {
        graphAL.deleteAllVerticesAndEdges();
    }

    @Test
    public void should_build_bfs_tree_from_just_two_objects() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);

        // when
        BFSTree bfsTree = BFS.buildBfsTree(graphAL, 1);

        // then
        assertEquals(0, bfsTree.getDistanceTo(1).intValue());
        assertEquals(1, bfsTree.getDistanceTo(2).intValue());
    }

    @Test
    public void should_build_bfs_tree_from_just_three_objects() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(2, 3);

        // when
        BFSTree bfsTree = BFS.buildBfsTree(graphAL, 1);

        // then
        assertEquals(1, bfsTree.getDistanceTo(2).intValue());
        assertEquals(2, bfsTree.getDistanceTo(3).intValue());
    }

    @Test
    public void should_return_null_if_no_element() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);

        // when
        BFSTree bfsTree = BFS.buildBfsTree(graphAL, 1);

        // then
        assertNull(bfsTree.getDistanceTo(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_graph_empty() throws Exception {
        BFS.buildBfsTree(new UndirectedGraphAL(), 1);
    }

    @Test
    public void should_return_null_to_all_vertices_in_graph_if_start_point_not_reachable() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);

        // when
        BFSTree bfsTree = BFS.buildBfsTree(graphAL, 3);

        // then
        assertNull(bfsTree.getDistanceTo(1));
        assertNull(bfsTree.getDistanceTo(2));
    }

    @Test
    public void should_return_correct_predecessor_element() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(2, 3);

        // when
        BFSTree bfsTree = BFS.buildBfsTree(graphAL, 1);

        // then
        assertNull(bfsTree.getPredecessor(1));
        assertEquals(1, bfsTree.getPredecessor(2).intValue());
        assertEquals(2, bfsTree.getPredecessor(3).intValue());
    }

    @Test
    public void should_return_null_if_no_predecessor_element() throws Exception {
        // given
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(2, 3);

        // when
        BFSTree bfsTree = BFS.buildBfsTree(graphAL, 1);

        // then
        assertNull(bfsTree.getPredecessor(10));
    }

}
