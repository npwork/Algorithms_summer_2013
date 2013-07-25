package coursera_stanford_2013.week2.quickSort.impl;


import coursera_stanford_2013.week2.quickSort.AbstractRecursiveQuickSort;

/**
 * Quick sort with random generated pivot point
 * Running time max <= O(n^2)
 * Running time avg <= O(n log n)
 */
public class RandomizedQuickSort extends AbstractRecursiveQuickSort {

    protected int partitionTemplateMethod(int[] inputArray, int l, int r) {
        int randomPivotIndex = randomBetweenTwoNumbers(l, r);
        swap(inputArray, l, randomPivotIndex);
        return partition(inputArray, l, r);
    }

    protected int randomBetweenTwoNumbers(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
}
