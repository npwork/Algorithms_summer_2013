package week2.comparisons;

import org.junit.Assert;
import org.junit.Test;
import util.IntegersFromFileReader;

import java.io.IOException;

public class LastElementPivotComparisonsTest extends AbstractQuckSortComparisonTest {

    private LastElementPivotComparisons lastElementPivotComparisons = new LastElementPivotComparisons();

    @Test
    public void smallTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_SMALL_EXAMPLE, 10);
        lastElementPivotComparisons.sort(ints);

        Assert.assertEquals(29, lastElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void mediumTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_MEDIUM_EXAMPLE, 100);
        lastElementPivotComparisons.sort(ints);

        Assert.assertEquals(587, lastElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void bigTest() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE_BIG_EXAMPLE, 1000);
        lastElementPivotComparisons.sort(ints);

        Assert.assertEquals(10184, lastElementPivotComparisons.getComparisonsCount().intValue());
    }

    @Test
    public void comparisonsCount() throws Exception {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE, 100000);
        lastElementPivotComparisons.sort(ints);

        System.out.println(lastElementPivotComparisons.countOfcomparisons);
    }
}
