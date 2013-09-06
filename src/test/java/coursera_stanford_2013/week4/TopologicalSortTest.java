package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TopologicalSortTest extends AbstractGraphTest {
    private GraphAL graph;

    public TopologicalSortTest(GraphAL graph) {
        this.graph = graph;
    }

    @Before
    public void setUp() throws Exception {
        graph.deleteAllVerticesAndEdges();
    }

    @Test
    public void should_compute_topological_sorted_dag() throws Exception {
        // given
        graph.addEdgeAndCreateVertex(1, 2);
        graph.addEdgeAndCreateVertex(2, 3);
        graph.addEdgeAndCreateVertex(3, 4);

        // when
        List<Vertex> topologicallySortedDAG = new TopologicalSort(graph).sort(graph);

        // then
        assertEquals(4, topologicallySortedDAG.size());

        assertEquals(4, topologicallySortedDAG.get(0).getValue());
        assertEquals(3, topologicallySortedDAG.get(1).getValue());
        assertEquals(2, topologicallySortedDAG.get(2).getValue());
        assertEquals(1, topologicallySortedDAG.get(3).getValue());
    }
}
