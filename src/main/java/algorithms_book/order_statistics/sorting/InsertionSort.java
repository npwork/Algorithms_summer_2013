package algorithms_book.order_statistics.sorting;

/**
 * Insertion sort
 * running time = O(n^2)
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

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
