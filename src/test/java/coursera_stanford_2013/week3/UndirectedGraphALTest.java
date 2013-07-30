package coursera_stanford_2013.week3;

import coursera_stanford_2013.week3.graphs.Edge;
import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

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

        assertEquals(key, retrieved.getValue());
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

        assertTrue(hasEdgeOne);
        assertTrue(hasEdgeTwo);
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

        assertFalse(hasEdgeOne);
        assertFalse(hasEdgeTwo);
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

        assertFalse(hasEdgeOne);
        assertFalse(hasEdgeTwo);
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

        assertNotNull(graph.getVertex(key1));
        assertNotNull(graph.getVertex(key2));
        assertTrue(hasEdgeOne);
        assertTrue(hasEdgeTwo);
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
        assertNull(graph.getVertex(key1));

        // 1 and 2
        assertFalse(graph.hasEdge(key1, key2));
        assertFalse(graph.hasEdge(key2, key1));

        // 1 and 3
        assertFalse(graph.hasEdge(key1, key3));
        assertFalse(graph.hasEdge(key3, key1));
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
        graph.changeEdge(new Edge(1, 3), new Edge(2, 3));

        // then
        assertFalse(graph.hasEdge(key1, key3));
        assertTrue(graph.hasEdge(key2, key3));
    }

    @Test
    public void countOfEdges_none() {
        // given
        int key1 = 1;
        int key2 = 2;

        // when
        int countOfEdges = graph.countOfEdges(key1, key2);

        // then
        assertEquals(0, countOfEdges);
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
        assertEquals(1, countOfEdges);
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
        assertEquals(2, countOfEdges);
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
        assertEquals(3, graph.vertexSize());

        assertNull(graph.getVertex(key3));

        assertEquals(2, graph.countOfEdges(newKey, key2));
        assertTrue(graph.hasEdge(newKey, key4));
        assertTrue(graph.hasEdge(key2, key4));
    }

    @Test
    public void cloneTest() throws CloneNotSupportedException {
        // > given
        int key1 = 1;
        int key2 = 2;
        int key3 = 3;
        int key4 = 4;
        graph.addEdgeAndCreateVertex(key1, key2);
        graph.addEdgeAndCreateVertex(key1, key3);
        graph.addEdgeAndCreateVertex(key3, key4);
        graph.addEdgeAndCreateVertex(key2, key4);
        graph.addEdgeAndCreateVertex(key3, key2);

        // > when

        UndirectedGraphAL clonedInstance = graph.clone();


        // > then
        assertTrue(graph != clonedInstance);

        // order holds
        assertTrue(graph.hasEdge(key1, key2));
        assertTrue(graph.hasEdge(key1, key3));
        assertTrue(graph.hasEdge(key3, key4));
        assertTrue(graph.hasEdge(key2, key4));
        assertTrue(graph.hasEdge(key3, key2));

        assertEquals(graph.getEdges().size(), clonedInstance.getEdges().size());
        assertEquals(graph.getVertexMap().size(), clonedInstance.getVertexMap().size());

        // edges
        for (int i = 0; i < clonedInstance.getEdges().size(); ++i) {
            Edge clonedEdge = clonedInstance.getEdges().get(i);
            Edge graphEdge = graph.getEdges().get(i);

            assertTrue(clonedEdge != graphEdge);

            // double check
            clonedEdge.setFrom(graphEdge.getFrom() + 100);
            assertTrue(clonedEdge.getFrom() != graphEdge.getFrom());
        }

        // vertexMaps
        Iterator<Map.Entry<Integer,Vertex>> clonedInstanceIterator = clonedInstance.getVertexMap().entrySet().iterator();
        Iterator<Map.Entry<Integer,Vertex>> graphIterator = graph.getVertexMap().entrySet().iterator();
        while(clonedInstanceIterator.hasNext()) {
            Map.Entry<Integer, Vertex> clonedValue = clonedInstanceIterator.next();
            Map.Entry<Integer, Vertex> graphValue = graphIterator.next();

            assertTrue(clonedValue.getKey().equals(graphValue.getKey()));
            assertTrue(clonedValue.getValue().equals(graphValue.getValue()));

            assertTrue(clonedValue.getValue() != graphValue.getValue());
        }
    }
}
