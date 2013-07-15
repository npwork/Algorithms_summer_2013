package week2.comparisons;

import org.junit.Test;
import util.IntegersFromFileReader;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractQuckSortComparisonTest {

    public static final String PATH_TO_FILE = "src/test/resources/week2/week2_input.txt";

    @Test
    public void inputFileExists() {
        File f = new File(PATH_TO_FILE);
        assertTrue(f.exists());
    }

    @Test
    public void fileHasValidData() throws Exception {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE, 100000);
        assertEquals(100000, ints.length);
    }
}
