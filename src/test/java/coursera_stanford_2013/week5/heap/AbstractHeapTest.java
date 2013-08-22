package coursera_stanford_2013.week5.heap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class AbstractHeapTest {
    protected Heap heap;
    protected int[] givenArray;

    protected void should_return_null_if_empty_heap() throws Exception {
        // given

        // when
        Integer retrievedValue = heap.poll();
        int sizeOfHeap = heap.getSize();

        // then
        assertEquals(0, sizeOfHeap);
        assertNull(retrievedValue);
    }

    public void should_change_size_when_adding_values() throws Exception {
        // given
        addAllElementsToHeap(heap, givenArray);

        // when
        int sizeOfHeap = heap.getSize();

        // then
        assertEquals(givenArray.length, sizeOfHeap);
    }

    protected void assertTwoArraysEquals(int[] expectedArray, int[] resultArray) {
        for (int i = 0; i < resultArray.length; ++i)
            assertEquals(expectedArray[i], resultArray[i]);
    }

    protected int[] getAllValues(Heap heap, int[] givenArray) {
        int[] resultArray = new int[givenArray.length];
        for (int i = 0; i < resultArray.length; ++i)
            resultArray[i] = heap.poll();
        return resultArray;
    }

    protected void addAllElementsToHeap(Heap heap, int[] givenArray) {
        for (int i : givenArray)
            heap.add(i);
    }

}
