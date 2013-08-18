package coursera_stanford_2013.week3.graphs;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


// @TODO works if we don't /2  in edge size
public class RandomContractionTest {
    UndirectedGraphAL graph;

    @Before
    public void init() {
        graph = new UndirectedGraphAL();
    }

    @Test
    @Ignore
    public void minimumCut() {
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
        assertTrue(count > 0); // since random algorithm
    }

    @Test
    @Ignore
    public void minimumCutMinimumValue() {
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

        // since random algorithm
        int numberOfTriesBeforeGiveUp = 5;

        // when
        for (int i = 0; i < numberOfTriesBeforeGiveUp; ++i) {
            int count = RandomContraction.minimumCutMinimumValue(graph, 10);
            // then
            if(count == 2) {
                return;
            }
        }

        throw new AssertionError("minimumCutMinimumValue did not make it");

    }
}
