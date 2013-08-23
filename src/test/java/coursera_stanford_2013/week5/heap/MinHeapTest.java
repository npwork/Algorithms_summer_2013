package coursera_stanford_2013.week5.heap;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class MinHeapTest extends AbstractHeapTest {
    private int[] expectedArray;

    @Before
    public void setUp() throws Exception {
        heap = new MinHeap();
        givenArray = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        expectedArray = Arrays.copyOf(givenArray, givenArray.length);
        Arrays.sort(expectedArray);
    }

    @Test
    public void should_return_null_if_empty_heap() throws Exception {
        super.should_return_null_if_empty_heap();
    }

    @Test
    public void should_change_size_when_adding_values() throws Exception {
        super.should_change_size_when_adding_values();
    }

    @Test
    public void should_return_values_in_sorted_order() throws Exception {
        // given
        addAllElementsToHeap(heap, givenArray);

        // when
        int[] resultArray = getAllValues(heap, givenArray);

        // then
        assertEquals(0, heap.getSize());
        assertTwoArraysEquals(expectedArray, resultArray);
    }

    @Test
     public void should_return_null_on_peek_call_if_empty() throws Exception {
        super.should_return_null_on_peek_call_if_empty();
    }

    @Test
    public void should_return_peek_value_if_not_empty() throws Exception {
        super.should_return_peek_value_if_not_empty();
    }

}
