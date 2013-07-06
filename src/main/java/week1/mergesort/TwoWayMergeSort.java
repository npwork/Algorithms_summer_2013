package week1.mergesort;

import java.util.Arrays;

public class TwoWayMergeSort {

    public static int[] sort(int[] givenArr) {
        return mergeSort(givenArr, 0, givenArr.length);
    }

    public static int[] mergeSort(int[] givenArr, int from, int to) {
        if(to - from == 1)
            return Arrays.copyOfRange(givenArr, from, from + 1);


        int middle = Math.round((to + from) / 2);

        int[] left = mergeSort(givenArr, from, middle);
        int[] right = mergeSort(givenArr, middle, to);

        int[] resultArr = merge(left, right);

        return resultArr;
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] resulArr = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < resulArr.length; ++k) {
            if(isIndexInTheEnd(a1, i)) {
                resulArr[k] = a2[j++];
            } else if(isIndexInTheEnd(a2, j)) {
                resulArr[k] = a1[i++];
            } else {
                if(a1[i] < a2[j]) {
                    resulArr[k] = a1[i++];
                } else {
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
