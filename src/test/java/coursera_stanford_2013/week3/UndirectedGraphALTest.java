package coursera_stanford_2013.week3;

import coursera_stanford_2013.week3.graphs.Edge;
import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class UndirectedGraphALTest {

    private UndirectedGraphAL graph;

    @Before
    public void init() {
        graph = new UndirectedGraphAL();
    }

    @Test
    public void addToGraph() {
        // given
        int key = 1;

        // when
        graph.addVertex(key);

        // then
        Vertex retrieved = graph.getVertex(key);

        Assert.assertEquals(key, retrieved.getValue());
    }

    @Test
    public void addEdge_present() {
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

        Assert.assertTrue(hasEdgeOne);
        Assert.assertTrue(hasEdgeTwo);
    }

    @Test
    public void hasEdge_present() {
        // given
        int key1 = 1;
        int key2 = 2;

        graph.addVertex(key1);
        graph.addVertex(key2);

        // when
        boolean hasEdgeOne = graph.hasEdge(key1, key2);
        boolean hasEdgeTwo = graph.hasEdge(key2, key1);

        // then

        Assert.assertFalse(hasEdgeOne);
        Assert.assertFalse(hasEdgeTwo);
    }

    @Test
    public void removeEdge() {
        // given
        int key1 = 1;
        int key2 = 2;

        graph.addVertex(key1);
        graph.addVertex(key2);

        graph.addEdge(key1, key2);

        // when
        graph.removeEdge(key1, key2);

        // then
        boolean hasEdgeOne = graph.hasEdge(key1, key2);
        boolean hasEdgeTwo = graph.hasEdge(key2, key1);

        Assert.assertFalse(hasEdgeOne);
        Assert.assertFalse(hasEdgeTwo);
    }

    @Test
    public void addEdgeAndCreateVertex() {
        // given
        int key1 = 1;
        int key2 = 2;

        // when
        graph.addEdgeAndCreateVertex(key1, key2);

        // then
        boolean hasEdgeOne = graph.hasEdge(key1, key2);
        boolean hasEdgeTwo = graph.hasEdge(key2, key1);

        Assert.assertNotNull(graph.getVertex(key1));
        Assert.assertNotNull(graph.getVertex(key2));
        Assert.assertTrue(hasEdgeOne);
        Assert.assertTrue(hasEdgeTwo);
    }

    @Test
    public void removeVertex() {
        // given
        int key1 = 1;
        int key2 = 2;
        int key3 = 3;
        graph.addEdgeAndCreateVertex(key1, key2);
        graph.addEdgeAndCreateVertex(key1, key3);

        // when
        graph.removeVertex(key1);

        // then
        Assert.assertNull(graph.getVertex(key1));

        // 1 and 2
        Assert.assertFalse(graph.hasEdge(key1, key2));
        Assert.assertFalse(graph.hasEdge(key2, key1));

        // 1 and 3
        Assert.assertFalse(graph.hasEdge(key1, key3));
        Assert.assertFalse(graph.hasEdge(key3, key1));
    }

    @Test
    public void changeEdge() {
        // given
        int key1 = 1;
        int key2 = 2;
        int key3 = 3;
        graph.addEdgeAndCreateVertex(key1, key2);
        graph.addEdgeAndCreateVertex(key1, key3);

        //when
        graph.changeEdge(new Edge(1,3), new Edge(2, 3));

        // then
        Assert.assertFalse(graph.hasEdge(key1, key3));
        Assert.assertTrue(graph.hasEdge(key2, key3));
    }

    @Test
    public void countOfEdges_none() {
        // given
        int key1 = 1;
        int key2 = 2;

        // when
        int countOfEdges = graph.countOfEdges(key1, key2);

        // then
        Assert.assertEquals(0, countOfEdges);
    }

    @Test
    public void countOfEdges_one() {
        // given
        int key1 = 1;
        int key2 = 2;
        graph.addEdgeAndCreateVertex(key1, key2);

        // when
        int countOfEdges = graph.countOfEdges(key1, key2);

        // then
        Assert.assertEquals(1, countOfEdges);
    }

    @Test
    public void countOfEdges_more_than_one() {
        // given
        int key1 = 1;
        int key2 = 2;
        graph.addEdgeAndCreateVertex(key1, key2);
        graph.addEdgeAndCreateVertex(key1, key2);

        // when
        int countOfEdges = graph.countOfEdges(key1, key2);

        // then
        Assert.assertEquals(2, countOfEdges);
    }

    @Test
    public void contraction() {
        // given
        int key1 = 1;
        int key2 = 2;
        int key3 = 3;
        int key4 = 4;
        graph.addEdgeAndCreateVertex(key1, key2);
        graph.addEdgeAndCreateVertex(key1, key3);
        graph.addEdgeAndCreateVertex(key3, key4);
        graph.addEdgeAndCreateVertex(key2, key4);
        graph.addEdgeAndCreateVertex(key3, key2);

        // when
        int newKey = graph.contract(key1, key3);

        // then
        Assert.assertEquals(3, graph.vertexSize());

        Assert.assertNull(graph.getVertex(key3));

        Assert.assertEquals(2, graph.countOfEdges(newKey, key2));
        Assert.assertTrue(graph.hasEdge(newKey, key4));
        Assert.assertTrue(graph.hasEdge(key2, key4));
    }
}
