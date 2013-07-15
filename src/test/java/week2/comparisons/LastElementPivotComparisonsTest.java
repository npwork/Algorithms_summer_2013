package week2.comparisons;

import org.junit.Test;
import util.IntegersFromFileReader;

public class LastElementPivotComparisonsTest extends AbstractQuckSortComparisonTest {

    private LastElementPivotComparisons lastElementPivotComparisons = new LastElementPivotComparisons();

    @Test
    public void comparisonsCount() throws Exception {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE, 100000);
        lastElementPivotComparisons.sort(ints);

        System.out.println(lastElementPivotComparisons.countOfcomparisons);
    }
}
