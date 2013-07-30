package coursera_stanford_2013.week3.task;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractMinimumCutTest {
    public String PATH_TO_FILE = "src/test/resources/coursera_stanford_2013/week3/kargerMinCut.txt";

    public String TEST_CASE_ONE_PATH_TO_FILE = "src/test/resources/coursera_stanford_2013/week3/testCase1.txt";
    public String TEST_CASE_TWO_PATH_TO_FILE = "src/test/resources/coursera_stanford_2013/week3/testCase2.txt";


    @Test
    public void inputFileExists() {
        File f = new File(PATH_TO_FILE);
        assertTrue(f.exists());
    }

    @Test
    public void fileHasValidData() throws Exception {
        UndirectedGraphAL graph = FileGraphReader.readGraphFromFile(PATH_TO_FILE);
        assertEquals(200, graph.vertexSize());
    }
}