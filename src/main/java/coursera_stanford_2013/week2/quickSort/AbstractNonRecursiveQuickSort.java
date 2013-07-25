package coursera_stanford_2013.week2.quickSort;

import java.util.LinkedList;

public abstract class AbstractNonRecursiveQuickSort extends AbstractQuickSort {

    public void sort(int[] inputArray) {
        int l = 0;
        int r = inputArray.length;

        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(l);
        stack.push(r);

        while (!stack.isEmpty()) {
            r = (Integer) stack.pop();
            l = (Integer) stack.pop();
            if (r <= l) continue;

            beforePartitionAction(inputArray, l, r);
            int resultPivotIndex = partition(inputArray, l, r);

            stack.push(l);
            stack.push(resultPivotIndex);

            stack.push(resultPivotIndex + 1);
            stack.push(r);
        }
    }

    protected void beforePartitionAction(int[] inputArray, int l, int r) {
    }
}
