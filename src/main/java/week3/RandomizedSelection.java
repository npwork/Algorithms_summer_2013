package week3;

public class RandomizedSelection {

    public static int select(int[] input, int ithOrderStatistics) {
        return select(input, 0, input.length, ithOrderStatistics);
    }

    private static int select(int[] input, int from, int to, int i) {
        if(Math.abs(from-to) <= 1)
            return input[from];

        int j = partition(input, from, to);

        if(j > i)
            return select(input, from, j , j - i);
        else if(j < i)
            return select(input, j + 1, to, i - j);
        else
            return input[j];
    }

    public static int partition(int[] array, int from, int to) {
        int i = from + 1;
        int pivotValue = array[from];

        for(int j = from + 1; j < to; ++j) {
            if(array[j] < pivotValue) {
                swap(array, j, i++);
            }
        }

        swap(array, from, i - 1);

        return i - 1;
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
