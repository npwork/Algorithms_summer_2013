package mergesort;

import org.junit.Test;

import java.util.Arrays;

public class MergeTest {

    @Test
    public void testMergeSameSizeArrays() {
        // given
        int[] arr1 = {3, 4, 5};
        int[] arr2 = {1, 2, 10};
        int[] expected = {1, 2, 3, 4, 5, 10};

        // when
        int[] mergedArray = TwoWayMergeSort.merge(arr1, arr2);

        // then
        Arrays.equals(mergedArray, expected);
    }

    @Test
    public void testMergeDifferentSizeArrays() {
        // given
        int[] arr1 = {3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 10};

        // when
        int[] mergedArray = TwoWayMergeSort.merge(arr1, arr2);

        // then
        Arrays.equals(mergedArray, expected);
    }

    @Test
    public void testMergeWithSameElements() {
        // given
        int[] arr1 = {3, 3, 3, 3};
        int[] arr2 = {1, 2, 10};
        int[] expected = {1, 2, 3, 3, 3, 3, 10};

        // when
        int[] mergedArray = TwoWayMergeSort.merge(arr1, arr2);

        // then
        Arrays.equals(mergedArray, expected);
    }
}
