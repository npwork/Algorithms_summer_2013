package coursera_stanford_2013.week2.comparisons;


import coursera_stanford_2013.week2.quickSort.AbstractNonRecursiveQuickSort;

import java.math.BigInteger;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MedianOfThreeNonRecursive extends AbstractNonRecursiveQuickSort {
    private static NavigableMap<Integer, Integer> items = new TreeMap<Integer, Integer>();
    public static BigInteger countOfcomparisons = new BigInteger("0");

    @Override
    protected void beforePartitionAction(int[] inputArray, int l, int r) {
        if (r - l < 3)
            return;
        items.put(inputArray[l], l);
        items.put(inputArray[r - 1], r - 1);
        int middle = (int) Math.floor((r + l) / 2);
        items.put(inputArray[middle], middle);

        // first
        Map.Entry<Integer, Integer> firstValue = items.pollFirstEntry();

        // middle
        Map.Entry<Integer, Integer> medianValue = items.pollFirstEntry();
        if (medianValue != null) {
            swap(inputArray, l, medianValue.getValue());
        } else {
            // >= 2 same elements
            swap(inputArray, l, firstValue.getValue());
        }

        items.clear();

        countOfcomparisons = countOfcomparisons.add(BigInteger.valueOf(r - l - 1));
    }

    public static BigInteger getComparisonsCount() {
        return countOfcomparisons;
    }
}
