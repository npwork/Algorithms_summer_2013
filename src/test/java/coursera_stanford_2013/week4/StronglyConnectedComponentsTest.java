package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.DirectedGraphAL;
import coursera_stanford_2013.week3.graphs.GraphAL;
import org.junit.Test;

public class StronglyConnectedComponentsTest {
    @Test
    public void should_compute_three_scc() throws Exception {
        // given
        GraphAL graphAL = initThreeSccGraph();

        // when
        StronglyConnectedComponents stronglyConnectedComponents = new StronglyConnectedComponents(graphAL);
        stronglyConnectedComponents.compute();

        // then


    }

    private DirectedGraphAL initThreeSccGraph() {
        DirectedGraphAL graphAL = new DirectedGraphAL();
        graphAL.addEdgeAndCreateVertex(1, 7);
        graphAL.addEdgeAndCreateVertex(7, 4);
        graphAL.addEdgeAndCreateVertex(4, 1);

        graphAL.addEdgeAndCreateVertex(7, 9);

        graphAL.addEdgeAndCreateVertex(9, 6);
        graphAL.addEdgeAndCreateVertex(6, 5);
        graphAL.addEdgeAndCreateVertex(5, 9);

        graphAL.addEdgeAndCreateVertex(6, 8);

        graphAL.addEdgeAndCreateVertex(8, 2);
        graphAL.addEdgeAndCreateVertex(2, 5);
        graphAL.addEdgeAndCreateVertex(5, 8);
        return graphAL;
    }
}
