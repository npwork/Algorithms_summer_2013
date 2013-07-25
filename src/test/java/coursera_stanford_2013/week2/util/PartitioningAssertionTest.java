package week2.util;

import org.junit.Test;

public class PartitioningAssertionTest {
    @Test
    public void assertNotLessThanAndNotGreaterThanTest_valid() {
        // given
        int[] validArray = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] invalidArray = {1, 2, 3, 4, 5, 6, 7, 8};

        // when
        PartitioningAssertion.assertNotLessThanAndNotGreaterThanPivotValue(validArray, 4);

        // then
        // nothing
    }

    @Test(expected = AssertionError.class)
    public void assertNotLessThanAndNotGreaterThanTest_invalid_left_part() {
        // given
        int[] invalidArray = {1, 2, 5, 4, 5, 6, 7, 8};

        // when
        PartitioningAssertion.assertNotLessThanAndNotGreaterThanPivotValue(invalidArray, 4);

        // then
        // exception
    }

    @Test(expected = AssertionError.class)
    public void assertNotLessThanAndNotGreaterThanTest_invalid_right_part() {
        // given
        int[] invalidArray = {1, 2, 3, 4, 5, 6, 0, 8};

        // when
        PartitioningAssertion.assertNotLessThanAndNotGreaterThanPivotValue(invalidArray, 4);

        // then
        // exception
    }
}
