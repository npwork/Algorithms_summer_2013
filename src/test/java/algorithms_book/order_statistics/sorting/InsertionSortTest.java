package algorithms_book.order_statistics.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {

    @Test
    public void simle_ascending_sort() {
        // given
        int[] ascendingArray = {1, 2, 3, 4, 5, 6};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};

        // when
        InsertionSort.sort(ascendingArray);

        // then
        Assert.assertTrue(Arrays.equals(expectedArray, ascendingArray));
    }

    @Test
    public void simle_descending_sort() {
        // given
        int[] ascendingArray = {6, 5, 4, 3, 2, 1};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};

        // when
        InsertionSort.sort(ascendingArray);

        // then
        Assert.assertTrue(Arrays.equals(expectedArray, ascendingArray));
    }
}
