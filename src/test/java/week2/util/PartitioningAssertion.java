package week2.util;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PartitioningAssertion {

    public static void assertNotLessThanAndNotGreaterThanPivotValue(int[] array, int pivotValue) {
        boolean passedPivotValue = false;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == pivotValue) {
                passedPivotValue = true;
                continue;
            }

            if (!passedPivotValue && array[i] > pivotValue) {
                // left
                throw new AssertionError(String.format("Left part: Value in i = %d,[%d > %d(pivotValue)]", i, array[i], pivotValue));
            } else if (passedPivotValue && array[i] < pivotValue) {
                // right
                throw new AssertionError(String.format("Right part: Value in i = %d,[%d > %d(pivotValue)]", i, array[i], pivotValue));
            }
        }
    }


}
