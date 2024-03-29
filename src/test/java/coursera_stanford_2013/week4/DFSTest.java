package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class DfsTest extends AbstractDfsTest {
    public DfsTest(GraphAL graph) {
        this.graph = graph;
    }

    public Forest computeForest() {
        return new Dfs(graph).computeForest();
    }
}
