package algorithms_book.order_statistics.sorting;

/**
 * Insertion sort
 * worst case running time = O(n^2)
 * best case(sorted) = O(n)
 * average = O(n + d)
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        int i = 0;
        int key = 0;

        for (int j = 1; j < arr.length; ++j) {
            i = j - 1;
            key = arr[j];

            while (i >= 0 && arr[i] > key) {
                swap(arr, i + 1, i--);
            }
        }
    }

    public static void reverseSort(int[] arr) {
        int i = 0;
        int key;
        for (int j = arr.length - 1; j >= 0; --j) {
            i = j + 1;
            key = arr[j];

            while (i < arr.length && arr[i] > key) {
                swap(arr, i, i - 1);
                i++;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
