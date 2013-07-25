package week2.comparisons;

import org.junit.Test;
import util.IntegersFromFileReader;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstElementPivotComparisonsTest extends AbstractQuckSortComparisonTest {

    private FirstElementPivotComparisons firstElementPivotComparisons = new FirstElementPivotComparisons();

    @Test
    public void smallTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_SMALL_EXAMPLE, 10);
        firstElementPivotComparisons.sort(ints);

        assertEquals(25, firstElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void mediumTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_MEDIUM_EXAMPLE, 100);
        firstElementPivotComparisons.sort(ints);

        assertEquals(615, firstElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void bigTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_BIG_EXAMPLE, 1000);
        firstElementPivotComparisons.sort(ints);

        assertEquals(10297, firstElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void comparisonsCount() throws Exception {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE, 10);

        firstElementPivotComparisons.sort(ints);
        System.out.println(firstElementPivotComparisons.getComparisonsCount());
    }

}
