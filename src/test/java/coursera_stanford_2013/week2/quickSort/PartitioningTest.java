package coursera_stanford_2013.week2.quickSort;

import coursera_stanford_2013.week2.quickSort.impl.RandomizedQuickSort;
import org.junit.Assert;
import org.junit.Test;
import coursera_stanford_2013.week2.util.PartitioningAssertion;

import java.util.Arrays;

public class PartitioningTest {

    private AbstractQuickSort abstractQuickSort = new RandomizedQuickSort();

    @Test
    public void partitioningTest() {
        // given
        int[] inputArray = {7, 6, 5, 10, 4, 15};
        int pivotValue = 7;

        // when
        abstractQuickSort.partition(inputArray, 0, inputArray.length);

        // then
        PartitioningAssertion.assertNotLessThanAndNotGreaterThanPivotValue(inputArray, pivotValue);
    }

    @Test
    public void partitioningTest_Bounds_eq_one() {
        // given
        int[] inputArray = {1, 2, 3, 4, 5};
        int[] expectedArray = {1, 2, 3, 4, 5};

        // when
        abstractQuickSort.partition(inputArray, 0, 1);

        // then
        Assert.assertTrue(Arrays.equals(inputArray, expectedArray));
    }
}
