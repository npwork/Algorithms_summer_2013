package coursera_stanford_2013.week1.mergesort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void testSortEvenArrayLength() {
        // given
        int[] givenArr = {3, 2, 1, 5, 6, 4, 9, 8};
        int[] expectedArr = {1, 2, 3, 4, 5, 6, 8, 9};

        assertMergeSort(givenArr, expectedArr);
    }

    @Test
    public void testSortOddArrayLength() {
        // given
        int[] givenArr = {3, 2, 1, 5, 6, 4, 9, 8, 15};
        int[] expectedArr = {1, 2, 3, 4, 5, 6, 8, 9, 15};

        assertMergeSort(givenArr, expectedArr);
    }

    @Test
    public void testSortEvenArrayLengthWithNegativeNumbers() {
        // given
        int[] givenArr = {3, 2, -1, 5, 6, 4, 9, 8, 15, -100};
        int[] expectedArr = {-100, -1, 2, 3, 4, 5, 6, 8, 9, 15};

        assertMergeSort(givenArr, expectedArr);
    }

    @Test
    public void testSortOddArrayLengthWithNegativeNumbers() {
        // given
        int[] givenArr = {3, 2, -1, 5, 6, 4, 9, 8, 15, -100, -500};
        int[] expectedArr = {-500, -100, -1, 2, 3, 4, 5, 6, 8, 9, 15};

        assertMergeSort(givenArr, expectedArr);
    }


    private void assertMergeSort(int[] givenArr, int[] expectedArr) {
        // when
        int[] sortedArr = MergeSort.sort(givenArr);

        //then
        Arrays.equals(sortedArr, expectedArr);
    }
}
