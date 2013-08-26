package coursera_stanford_2013.week2.comparisons;

import coursera_stanford_2013.util.NumbersFromFileReader;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractQuckSortComparisonTest {

    public String PATH_TO_FILE = "src/test/resources/coursera_stanford_2013/week2/week2_input.txt";

    public String PATH_TO_FILE_SMALL_EXAMPLE = "src/test/resources/coursera_stanford_2013/week2/custom_small_test.txt";
    public String PATH_TO_FILE_MEDIUM_EXAMPLE = "src/test/resources/coursera_stanford_2013/week2/custom_medium_test.txt";
    public String PATH_TO_FILE_BIG_EXAMPLE = "src/test/resources/coursera_stanford_2013/week2/custom_big_test.txt";

    @Test
    public void inputFileExists() {
        File f = new File(PATH_TO_FILE);
        assertTrue(f.exists());
    }

    @Test
    public void fileHasValidData() throws Exception {
        int[] ints = NumbersFromFileReader.readIntArrayFromFile(PATH_TO_FILE, 100000);
        assertEquals(100000, ints.length);
    }
}
