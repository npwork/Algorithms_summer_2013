package week2.quickSort;

import org.junit.Assert;
import org.junit.Test;
import week2.quickSort.AbstractQuickSort;
import week2.quickSort.RandomizedQuickSort;
import week2.quickSort.SimpleQuickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {

    private RandomizedQuickSort randomizedQuickSort = new RandomizedQuickSort();
    private SimpleQuickSort simpleQuickSort = new SimpleQuickSort();
    private NonRecursiveQuickSort nonRecursiveQuickSort = new NonRecursiveQuickSort();

    @Test
    public void randomizedQuickSortTest() {
        sortTest(randomizedQuickSort);
    }

    @Test
    public void simpleQuickSortTest() {
        sortTest(simpleQuickSort);
    }

    @Test
    public void nonRecursiveQuickSortTest() {
        sortTest(nonRecursiveQuickSort);
    }

    private void sortTest(Sortable sortable) {
        // given
        int[] randomArray = generateRandomArray(100);
        int[] sortedCopyOfRandomArray = Arrays.copyOf(randomArray, randomArray.length);
        Arrays.sort(sortedCopyOfRandomArray);

        // when
        sortable.sort(randomArray);

        // then
        Assert.assertTrue(Arrays.equals(randomArray, sortedCopyOfRandomArray));

    }

    private int[] generateRandomArray(int length) {
        int[] resultArray = new int[length];
        Random random = new Random(Integer.MAX_VALUE);
        for (int i = 0; i < length; ++i) {
            resultArray[i] = random.nextInt();
        }

        return resultArray;
    }


}
