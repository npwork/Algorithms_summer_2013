package coursera_stanford_2013.week3.graphs;

import org.junit.Before;
import org.junit.Test;

public class RandomContractionTest {
    UndirectedGraphAL graph;

    @Before
    public void init() {
        graph = new UndirectedGraphAL();
    }

    @Test
    public void test() {
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
        int count = RandomContraction.minimumCut(graph);

        // then
        System.out.println(count);
    }
}
