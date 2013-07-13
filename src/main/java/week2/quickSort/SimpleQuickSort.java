package week2.quickSort;

/**
 * Quick sort without random generated pivot point
 * Running time <= O(n^2)
 */
public class SimpleQuickSort extends AbstractQuickSort {
    @Override
    protected int partitionTemplateMethod(int[] inputArray, int l, int r) {
        return partition(inputArray, l, r);
    }
}
