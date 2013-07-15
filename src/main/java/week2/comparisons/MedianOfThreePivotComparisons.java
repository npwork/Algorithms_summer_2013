package week2.comparisons;

import week2.quickSort.AbstractQuickSort;
import week2.quickSort.AbstractRecursiveQuickSort;

import java.math.BigInteger;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

// Using median of three elements to swap
public class MedianOfThreePivotComparisons extends AbstractRecursiveQuickSort {
    public static BigInteger countOfcomparisons = new BigInteger("0");
    private static NavigableMap<Integer, Integer> items = new TreeMap<Integer, Integer>();

    @Override
    protected int partitionTemplateMethod(int[] inputArray, int l, int r) {
        countOfcomparisons = countOfcomparisons.add(BigInteger.valueOf(r - l - 1));
        if (r - l < 3)
            return partition(inputArray, l, r);

        items.put(inputArray[l], l);
        items.put(inputArray[r - 1], r - 1);
        int middle = (int) Math.floor((r + l) / 2);
        items.put(inputArray[middle], middle);

        // first
        Map.Entry<Integer, Integer> firstValue = items.pollFirstEntry();

        // middle
        Map.Entry<Integer, Integer> medianValue = items.pollFirstEntry();
        if(medianValue != null) {
            swap(inputArray, l, medianValue.getValue());
        } else {
            // >= 2 same elements
            swap(inputArray, l, firstValue.getValue());
        }

        items.clear();


        return partition(inputArray, l, r);
    }

    public static BigInteger getComparisonsCount() {
        return countOfcomparisons;
    }
}
