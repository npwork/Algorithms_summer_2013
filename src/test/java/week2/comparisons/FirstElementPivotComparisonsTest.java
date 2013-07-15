package week2.comparisons;

import org.junit.Test;
import util.IntegersFromFileReader;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstElementPivotComparisonsTest extends AbstractQuckSortComparisonTest {

    private FirstElementPivotComparisons firstElementPivotComparisons = new FirstElementPivotComparisons();

    @Test
    public void comparisonsCount() throws Exception {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE, 100000);

        firstElementPivotComparisons.sort(ints);
        System.out.println(firstElementPivotComparisons.getComparisonsCount());
    }

}
