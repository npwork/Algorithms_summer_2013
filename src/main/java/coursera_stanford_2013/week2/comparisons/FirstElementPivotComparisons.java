package coursera_stanford_2013.week2.comparisons;

import coursera_stanford_2013.week2.quickSort.AbstractRecursiveQuickSort;

import java.math.BigInteger;

// Using first element as pivot
// Running time <= O(n^2)
public class FirstElementPivotComparisons extends AbstractRecursiveQuickSort {

    private static BigInteger comparisonsCount = new BigInteger("0");

    @Override
    protected int partitionTemplateMethod(int[] inputArray, int l, int r) {
        comparisonsCount = comparisonsCount.add(BigInteger.valueOf(r - l - 1));
        return partition(inputArray, l, r);
    }

    public static BigInteger getComparisonsCount() {
        return comparisonsCount;
    }
}