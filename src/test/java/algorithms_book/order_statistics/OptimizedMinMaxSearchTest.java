package algorithms_book.order_statistics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptimizedMinMaxSearchTest {

    @Test
    public void test_increasing_order() {
        // given
        int[] givenArray = {1, 2, 3, 4, 5, 6};
        int expectedMin = 1;
        int expectedMax = 6;

        // when
        OptimizedMinMaxSearch.MinMaxValue minMaxValue = OptimizedMinMaxSearch.getMinAndMax(givenArray);

        // then
        assertEquals(expectedMin, minMaxValue.getMin());
        assertEquals(expectedMax, minMaxValue.getMax());
    }

    @Test
    public void test_decreasing_order() {
        // given
        int[] givenArray = {6, 5, 4, 3, 2, 1};
        int expectedMin = 1;
        int expectedMax = 6;

        // when
        OptimizedMinMaxSearch.MinMaxValue minMaxValue = OptimizedMinMaxSearch.getMinAndMax(givenArray);

        // then
        assertEquals(expectedMin, minMaxValue.getMin());
        assertEquals(expectedMax, minMaxValue.getMax());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_empty_array() {
        // given
        int[] givenArray = {};

        // when
        OptimizedMinMaxSearch.MinMaxValue minMaxValue = OptimizedMinMaxSearch.getMinAndMax(givenArray);

        // then exception
    }

    @Test
    public void test_one_element_in_array() {
        // given
        int expectedMinAndMax = 1;
        int[] givenArray = {expectedMinAndMax};

        // when
        OptimizedMinMaxSearch.MinMaxValue minMaxValue = OptimizedMinMaxSearch.getMinAndMax(givenArray);

        // then
        assertEquals(expectedMinAndMax, minMaxValue.getMin());
        assertEquals(expectedMinAndMax, minMaxValue.getMax());
    }

    @Test
    public void test_two_elements_in_array_first_is_bigger() {
        // given
        int expectedMin = 1;
        int expectedMax = 2;
        int[] givenArray = {expectedMin, expectedMax};

        // when
        OptimizedMinMaxSearch.MinMaxValue minMaxValue = OptimizedMinMaxSearch.getMinAndMax(givenArray);

        // then
        assertEquals(expectedMin, minMaxValue.getMin());
        assertEquals(expectedMax, minMaxValue.getMax());
    }

    @Test
    public void test_two_elements_in_array_second_is_bigger() {
        // given
        int expectedMin = 1;
        int expectedMax = 2;
        int[] givenArray = {expectedMax, expectedMin};

        // when
        OptimizedMinMaxSearch.MinMaxValue minMaxValue = OptimizedMinMaxSearch.getMinAndMax(givenArray);

        // then
        assertEquals(expectedMin, minMaxValue.getMin());
        assertEquals(expectedMax, minMaxValue.getMax());
    }
}
