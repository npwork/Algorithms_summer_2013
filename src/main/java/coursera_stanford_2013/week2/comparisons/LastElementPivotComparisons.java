package week2.comparisons;

import week2.quickSort.AbstractQuickSort;
import week2.quickSort.AbstractRecursiveQuickSort;

import java.math.BigInteger;

// Using last element as pivot
// Running time <= O(n^2)
public class LastElementPivotComparisons extends AbstractRecursiveQuickSort {
    public static BigInteger countOfcomparisons = new BigInteger("0");

    @Override
    protected int partitionTemplateMethod(int[] inputArray, int l, int r) {
        countOfcomparisons = countOfcomparisons.add(BigInteger.valueOf(r - l - 1));
        swap(inputArray, l, r-1);
        return partition(inputArray, l, r);
    }

    public static BigInteger getComparisonsCount() {
        return countOfcomparisons;
    }
}
