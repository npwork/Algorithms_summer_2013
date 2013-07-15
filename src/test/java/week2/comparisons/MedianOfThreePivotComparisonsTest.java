package week2.comparisons;

import org.junit.Assert;
import org.junit.Test;
import util.IntegersFromFileReader;
import week2.quickSort.impl.SimpleNonRecursiveQuickSort;

import java.io.IOException;

public class MedianOfThreePivotComparisonsTest extends AbstractQuckSortComparisonTest {

    private MedianOfThreePivotComparisons medianOfThreePivotComparisons = new MedianOfThreePivotComparisons();

    @Test
    public void smallTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_SMALL_EXAMPLE, 10);
        medianOfThreePivotComparisons.sort(ints);

        Assert.assertEquals(21, medianOfThreePivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void mediumTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_MEDIUM_EXAMPLE, 100);
        medianOfThreePivotComparisons.sort(ints);

        Assert.assertEquals(518, medianOfThreePivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void bigTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_BIG_EXAMPLE, 1000);
        medianOfThreePivotComparisons.sort(ints);

        Assert.assertEquals(8921, medianOfThreePivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void comparisonsCount() throws Exception {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE, 100000); //100000
        medianOfThreePivotComparisons.sort(ints);

        System.out.println(medianOfThreePivotComparisons.countOfcomparisons);
    }
}
