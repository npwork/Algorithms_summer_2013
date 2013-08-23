package coursera_stanford_2013.week5.heap;

public class MedianMaintenance {
    private int size;
    private Heap lowHeap = new MaxHeap();
    private Heap highHeap = new MinHeap();


    public void add(int value) {
        if (isEmpty())
            addToEmptyCollection(value);
        else
            addToNonEmptyCollection(value);
    }

    private void addToEmptyCollection(int value) {
        lowHeap.add(value);
        size++;
    }

    private void addToNonEmptyCollection(int value) {
        if (value < lowHeap.peek())
            lowHeap.add(value);
        else
            highHeap.add(value);

        size++;
        balanceValuesBetweenHeaps();
    }

    private void balanceValuesBetweenHeaps() {
        if (heapsAreEqualSize())
            return;
        else if (lowerHeapBiggerThanHigherHeap(1))
            highHeap.add(lowHeap.poll());
        else if (highHeapBiggerThanLowerHeap(1))
            lowHeap.add(highHeap.poll());
    }

    private boolean highHeapBiggerThanLowerHeap(int higherThanOnValue) {
        return highHeap.getSize() - lowHeap.getSize() > higherThanOnValue;
    }

    private boolean lowerHeapBiggerThanHigherHeap(int higherThanOnValue) {
        return lowHeap.getSize() - highHeap.getSize() > higherThanOnValue;
    }

    private boolean heapsAreEqualSize() {
        return lowHeap.getSize() == highHeap.getSize();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer medium() {
        if (heapsAreEqualSize())
            return lowHeap.peek();
        else if (lowerHeapBiggerThanHigherHeap(0))
            return lowHeap.peek();
        else
            return highHeap.peek();
    }
}
