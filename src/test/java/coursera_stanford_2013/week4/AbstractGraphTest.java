package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.DirectedGraphAL;
import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import org.junit.runners.Parameterized;

import java.util.Arrays;

public abstract class AbstractGraphTest {
    @Parameterized.Parameters
    public static java.util.Collection<Object[]> data() {
        Object[][] data = new Object[][]{{new UndirectedGraphAL()}, {new DirectedGraphAL()}};
        return Arrays.asList(data);
    }
}
