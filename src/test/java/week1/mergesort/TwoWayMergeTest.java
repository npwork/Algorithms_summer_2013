package week1.mergesort;

import org.junit.Test;

import java.util.Arrays;

public class TwoWayMergeTest {

    @Test
    public void testMergeSameSizeArrays() {
        // given
        int[] arr1 = {3, 4, 5};
        int[] arr2 = {1, 2, 10};
        int[] expected = {1, 2, 3, 4, 5, 10};

        assertTwoWayMerged(arr1, arr2, expected);
    }


    @Test
    public void testMergeDifferentSizeArrays() {
        // given
        int[] arr1 = {3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 10};

        assertTwoWayMerged(arr1, arr2, expected);
    }

    @Test
    public void testMergeWithSameElements() {
        // given
        int[] arr1 = {3, 3, 3, 3};
        int[] arr2 = {1, 2, 10};
        int[] expected = {1, 2, 3, 3, 3, 3, 10};

        assertTwoWayMerged(arr1, arr2, expected);
    }

    private void assertTwoWayMerged(int[] arr1, int[] arr2, int[] expected) {
        // when
        int[] mergedArray = TwoWayMergeSort.merge(arr1, arr2);

        Arrays.equals(mergedArray, expected);
    }
}
