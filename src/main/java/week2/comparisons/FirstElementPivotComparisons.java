package week2.comparisons;

import week2.quickSort.AbstractQuickSort;

import java.math.BigInteger;

public class FirstElementPivotComparisons extends AbstractQuickSort {

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