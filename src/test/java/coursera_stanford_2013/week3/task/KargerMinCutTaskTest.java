package coursera_stanford_2013.week3.task;

import coursera_stanford_2013.week3.RandomContraction;
import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class KargerMinCutTaskTest extends AbstractMinimumCutTest {
    @Test
    @Ignore // working to slow for unit test
    public void test() throws IOException {
        UndirectedGraphAL graph = FileGraphReader.readGraphFromFile(PATH_TO_FILE);
        int minimumCutEdge = RandomContraction.minimumCutMinimumValue(graph, 100);
        assertEquals(17, minimumCutEdge);
    }

    @Test
    @Ignore
    public void testCase1() throws IOException {
        UndirectedGraphAL graph = FileGraphReader.readGraphFromFile(TEST_CASE_ONE_PATH_TO_FILE);
        int minimumCutEdge = RandomContraction.minimumCutMinimumValue(graph, 10);
        assertEquals(2, minimumCutEdge);
    }

    @Test
    @Ignore
    public void testCase2() throws IOException {
        UndirectedGraphAL graph = FileGraphReader.readGraphFromFile(TEST_CASE_TWO_PATH_TO_FILE);
        int minimumCutEdge = RandomContraction.minimumCutMinimumValue(graph, 10);
        assertEquals(1, minimumCutEdge);
    }
}
