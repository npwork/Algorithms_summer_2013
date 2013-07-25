package coursera_stanford_2013.week2.quickSort;

/**
 * Implementing Template Method pattern
 */

public abstract class AbstractQuickSort implements Sortable {

    protected boolean isSingleElementInArray(int l, int r) {
        return Math.abs(l - r) <= 1;
    }

    protected void swap(int[] inputArray, int i, int j) {
        int tmp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = tmp;
    }

    /**
     * @return pivot index
     */
    public int partition(int[] inputArray, int l, int r) {
        int i = l + 1;
        int pivotValue = inputArray[l];
        for (int j = l + 1; j < r; ++j) {
            if (inputArray[j] < pivotValue) {
                swap(inputArray, i++, j);
            }
        }
        swap(inputArray, l, i - 1);
        return i - 1;
    }
}
