package week2.quickSort;

public abstract class AbstractRecursiveQuickSort extends AbstractQuickSort {

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

    private void callLeftAndRightSort(int[] inputArray, int l, int pivotPosition, int r) {
        sort(inputArray, l, pivotPosition);
        sort(inputArray, pivotPosition + 1, r);
    }

}
