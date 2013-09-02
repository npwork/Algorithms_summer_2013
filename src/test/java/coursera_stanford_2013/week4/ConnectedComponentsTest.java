package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ConnectedComponentsTest {

    @Test
    public void should_return_one_if_only_one_connected_component() throws Exception {
        // given
        UndirectedGraphAL graphAL = new UndirectedGraphAL();
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(2, 3);

        // when
        int connectedComponentsCount = ConnectedComponents.connectedComponentsCount(graphAL);

        // then
        assertEquals(1, connectedComponentsCount);
    }

    @Test
    public void should_return_two_if_only_two_connected_component() throws Exception {
        // given
        UndirectedGraphAL graphAL = new UndirectedGraphAL();
        graphAL.addEdgeAndCreateVertex(1, 2);
        graphAL.addEdgeAndCreateVertex(3, 4);

        // when
        int connectedComponentsCount = ConnectedComponents.connectedComponentsCount(graphAL);

        // then
        assertEquals(2, connectedComponentsCount);
    }
}
