package week3;

public class RandomizedSelection {

    public static int select(int[] input, int ithOrderStatistics) {
        return select(input, 0, input.length, ithOrderStatistics);
    }

    /**
     * @param i i_th order statistics
     */
    private static int select(int[] input, int from, int to, int i) {
        if(Math.abs(from-to) <= 1)
            return input[from];

        // randomize pivot
        int randomPivotIndex = randomBetweenTwoNumbers(from, to);
        swap(input, from, randomPivotIndex);
        int partitionValueIndex = partition(input, from, to);

        // j - partitionValueIndex value order statistics in sub array
        int j = partitionValueIndex - from + 1;

        if(j > i)
            return select(input, from, partitionValueIndex , i);
        else if(j < i)
            return select(input, partitionValueIndex + 1, to, i - j);
        else
            return input[partitionValueIndex];
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

    private static int randomBetweenTwoNumbers(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
}
