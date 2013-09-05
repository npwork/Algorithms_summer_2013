package coursera_stanford_2013.week3.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectedGraphALTest extends AbstractGraphALTest {
    private DirectedGraphAL graph;

    @Before
    public void setUp() throws Exception {
        graph = new DirectedGraphAL();
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
}
