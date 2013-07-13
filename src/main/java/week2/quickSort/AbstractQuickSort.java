package week2.quickSort;

/**
 * Implementing Template Method pattern
 */

public abstract class AbstractQuickSort {

    public void sort(int[] inputArray) {
        sort(inputArray, 0, inputArray.length);
    }

    protected void sort(int[] inputArray, int l, int r) {
        if (isSingleElementInArray(l, r)) {
            return;
        }

        int pivotPosition = partitionTemplateMethod(inputArray, l, r);

        callLeftAndRightSort(inputArray, l, pivotPosition, r);
    }

    protected abstract int partitionTemplateMethod(int[] inputArray, int l, int r);

    private boolean isSingleElementInArray(int l, int r) {
        return Math.abs(l - r) <= 1;
    }

    protected void swap(int[] inputArray, int i, int j) {
        int tmp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = tmp;
    }

    private void callLeftAndRightSort(int[] inputArray, int l, int pivotPosition, int r) {
        sort(inputArray, l, pivotPosition);
        sort(inputArray, pivotPosition + 1, r);
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
