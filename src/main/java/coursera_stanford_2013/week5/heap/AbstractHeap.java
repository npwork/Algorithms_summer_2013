package coursera_stanford_2013.week5.heap;

public abstract class AbstractHeap implements Heap {
    private static final int DEFAULT_HEAP_SIZE = 10;
    protected int nextIndex = 1; // starting from 1
    protected int[] values = new int[DEFAULT_HEAP_SIZE];

    @Override
    public Integer peek() {
        if(isEmpty())
            return null;
        return values[1];
    }

    @Override
    public boolean isEmpty() {
        return nextIndex == 1;
    }

    protected void addRootElement(int value) {
        safelyAddElement(value, nextIndex++);
    }

    protected void addNonRootElement(int value) {
        safelyAddElement(value, nextIndex);
        bubbleUpValue(nextIndex++);
    }


    protected void safelyAddElement(int value, int index) {
        ensureCapacity(index);
        values[index] = value;
    }

    protected void ensureCapacity(int index) {
        if (values.length == index)
            doubleArraySize();
    }

    protected void doubleArraySize() {
        int[] newArray = new int[2 * values.length];
        System.arraycopy(values, 0, newArray, 0, values.length);
        values = newArray;
    }

    protected void bubbleUpValue(int position) {
        if (position == 1)
            return;

        int parentIndex = getParentIndex(position);
        if (bubbleUpBrokeCondition(position, parentIndex)) {
            swap(position, parentIndex);
            bubbleUpValue(parentIndex);
        }
    }

    protected abstract boolean bubbleUpBrokeCondition(int positionIndex, int parentIndex);

    protected int getParentIndex(int position) {
        if (position % 2 == 0)
            return position / 2;
        else
            return (int) Math.floor(position / 2);
    }

    protected boolean hasOnlySecondChild(int firstChildIndex, int secondChildIndex) {
        return !hasChild(firstChildIndex) && hasChild(secondChildIndex);
    }

    protected boolean hasOnlyFirstChild(int firstChildIndex, int secondChildIndex) {
        return hasChild(firstChildIndex) && !hasChild(secondChildIndex);
    }

    protected boolean hasChild(int index) {
        return index != -1 && index < nextIndex;

    }

    protected int getFirstChildIndex(int position) {
        int firstChildPosition = position * 2;
        return getIndexOrMinusOneIfOutOfBounds(firstChildPosition);
    }

    protected int getSecondChildIndex(int position) {
        int firstChildPosition = position * 2 + 1;
        return getIndexOrMinusOneIfOutOfBounds(firstChildPosition);
    }

    protected int getIndexOrMinusOneIfOutOfBounds(int firstChildPosition) {
        if (firstChildPosition < values.length)
            return firstChildPosition;
        else
            return -1;
    }


    protected int pollFromNonEmptyArray() {
        int returnValue = values[1];
        swap(1, --nextIndex);
        bubbleDownValue(1);
        return returnValue;
    }

    protected abstract void bubbleDownValue(int position);

    protected void swapAndBubbleDown(int position, int childIndex) {
        swap(childIndex, position);
        bubbleDownValue(childIndex);
    }

    protected void swap(int positionIndex, int parentIndex) {
        int tmp = values[positionIndex];
        values[positionIndex] = values[parentIndex];
        values[parentIndex] = tmp;
    }

    @Override
    public int getSize() {
        return nextIndex - 1;
    }
}
