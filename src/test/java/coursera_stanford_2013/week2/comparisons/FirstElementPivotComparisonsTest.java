package coursera_stanford_2013.week2.comparisons;

import coursera_stanford_2013.util.NumbersFromFileReader;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Not ready yet
 */
@Ignore
public class FirstElementPivotComparisonsTest extends AbstractQuckSortComparisonTest {

    private FirstElementPivotComparisons firstElementPivotComparisons = new FirstElementPivotComparisons();

    @Test
    public void smallTest() throws IOException {
        int[] ints = NumbersFromFileReader.readIntArrayFromFile(PATH_TO_FILE_SMALL_EXAMPLE, 10);
        firstElementPivotComparisons.sort(ints);

        assertEquals(25, firstElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void mediumTest() throws IOException {
        int[] ints = NumbersFromFileReader.readIntArrayFromFile(PATH_TO_FILE_MEDIUM_EXAMPLE, 100);
        firstElementPivotComparisons.sort(ints);

        assertEquals(615, firstElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void bigTest() throws IOException {
        int[] ints = NumbersFromFileReader.readIntArrayFromFile(PATH_TO_FILE_BIG_EXAMPLE, 1000);
        firstElementPivotComparisons.sort(ints);

        assertEquals(10297, firstElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void comparisonsCount() throws Exception {
        int[] ints = NumbersFromFileReader.readIntArrayFromFile(PATH_TO_FILE, 10);

        firstElementPivotComparisons.sort(ints);
        System.out.println(firstElementPivotComparisons.getComparisonsCount());
    }

}
