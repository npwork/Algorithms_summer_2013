package coursera_stanford_2013.week5.heap;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class HeapTest {
    private Heap heap;
    private int[] givenArray;
    private int[] expectedArray;

    @Before
    public void setUp() throws Exception {
        heap = new Heap();
        givenArray = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        expectedArray = Arrays.copyOf(givenArray, givenArray.length);
        Arrays.sort(expectedArray);
    }

    @Test
    public void should_return_null_if_empty_heap() throws Exception {
        // given

        // when
        Integer retrievedValue = heap.poll();
        int sizeOfHeap = heap.getSize();

        // then
        assertEquals(0, sizeOfHeap);
        assertNull(retrievedValue);
    }

    @Test
    public void should_change_size_when_adding_values() throws Exception {
        // given
        addAllElementsToHeap(heap, givenArray);

        // when
        int sizeOfHeap = heap.getSize();

        // then
        assertEquals(givenArray.length, sizeOfHeap);
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

    private void assertTwoArraysEquals(int[] expectedArray, int[] resultArray) {
        for (int i = 0; i < resultArray.length; ++i)
            assertEquals(expectedArray[i], resultArray[i]);
    }

    private int[] getAllValues(Heap heap, int[] givenArray) {
        int[] resultArray = new int[givenArray.length];
        for (int i = 0; i < resultArray.length; ++i)
            resultArray[i] = heap.poll();
        return resultArray;
    }

    private void addAllElementsToHeap(Heap heap, int[] givenArray) {
        for (int i : givenArray)
            heap.add(i);
    }
}
