package week2.quickSort;

import java.util.LinkedList;

public class NonRecursiveQuickSort extends AbstractQuickSort {
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
            int resultPivotIndex = partition(inputArray, l, r);

            stack.push(l);
            stack.push(resultPivotIndex);

            stack.push(resultPivotIndex + 1);
            stack.push(r);
        }
    }

    @Override
    protected int partitionTemplateMethod(int[] inputArray, int l, int r) {
        // Non recursive quick sort doesn't use partitionTemplateMethod
        return 0;
    }
}
