package coursera_stanford_2013.week1.inversions;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * This file contains all of the 100,000 integers between 1 and 100,000 (inclusive) in some order, with no integer repeated.
 * Your task is to compute the number of inversions in the file given, where the ith row of the file indicates the ith entry of an array.
 * Because of the large size of this array, you should implement the fast divide-and-conquer algorithm covered in the video lectures.
 * The numeric answer for the given input file should be typed in the space below.
 */
public class InversionsCounter {
    private BigInteger countOfInversions = new BigInteger("0");

    public BigInteger countOfInversions(int[] givenArr) {
        mergeSort(givenArr, 0, givenArr.length);
        return countOfInversions;
    }

    public int[] mergeSort(int[] givenArr, int from, int to) {
        if (to - from == 1)
            return Arrays.copyOfRange(givenArr, from, from + 1);


        int middle = Math.round((to + from) / 2);

        int[] left = mergeSort(givenArr, from, middle);
        int[] right = mergeSort(givenArr, middle, to);

        int[] resultArr = merge(left, right);

        return resultArr;
    }

    public int[] merge(int[] a1, int[] a2) {
        int[] resulArr = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < resulArr.length; ++k) {
            if (isIndexInTheEnd(a1, i)) {
                resulArr[k] = a2[j++];
            } else if (isIndexInTheEnd(a2, j)) {
                resulArr[k] = a1[i++];
            } else {
                if (a1[i] < a2[j]) {
                    resulArr[k] = a1[i++];
                } else {
                    countOfInversions = countOfInversions.add(BigInteger.valueOf(a1.length - i));
                    resulArr[k] = a2[j++];
                }
            }
        }

        return resulArr;
    }

    private static boolean isIndexInTheEnd(int[] arr, int idx) {
        return idx == arr.length;
    }
}
