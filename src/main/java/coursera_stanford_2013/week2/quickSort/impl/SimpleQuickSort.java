package coursera_stanford_2013.week2.quickSort.impl;

import coursera_stanford_2013.week2.quickSort.AbstractRecursiveQuickSort;

/**
 * Quick sort without random generated pivot point
 * Running time <= O(n^2)
 */
public class SimpleQuickSort extends AbstractRecursiveQuickSort {
    @Override
    protected int partitionTemplateMethod(int[] inputArray, int l, int r) {
        return partition(inputArray, l, r);
    }
}
