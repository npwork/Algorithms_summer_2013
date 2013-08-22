package coursera_stanford_2013.week5.heap;

public class Heap {
    private static final int DEFAULT_HEAP_SIZE = 10;
    private int nextIndex = 1; // starting from 1
    private int[] values = new int[DEFAULT_HEAP_SIZE];


    public void add(int value) {
        if (isEmpty())
            addRootElement(value);
        else
            addNonRootElement(value);
    }

    private void addRootElement(int value) {
        safelyAddElement(value, nextIndex++);
    }

    private void addNonRootElement(int value) {
        safelyAddElement(value, nextIndex);
        bubbleUpValue(nextIndex++);
    }

    private void safelyAddElement(int value, int index) {
        ensureCapacity(index);
        values[index] = value;
    }

    private void ensureCapacity(int index) {
        if (values.length == index)
            doubleArraySize();
    }

    private void doubleArraySize() {
        int[] newArray = new int[2 * values.length];
        System.arraycopy(values, 0, newArray, 0, values.length);
        values = newArray;
    }

    private void bubbleUpValue(int position) {
        if (position == 1)
            return;

        int parentIndex = getParentIndex(position);
        if (values[parentIndex] > values[position]) {
            swap(position, parentIndex);
            bubbleUpValue(parentIndex);
        }
    }

    private void swap(int position, int parentIndex) {
        int tmp = values[position];
        values[position] = values[parentIndex];
        values[parentIndex] = tmp;
    }

    private int getParentIndex(int position) {
        if (position % 2 == 0)
            return position / 2;
        else
            return (int) Math.floor(position / 2);
    }

    public boolean isEmpty() {
        return nextIndex == 1;
    }

    public int getSize() {
        return nextIndex - 1;
    }

    public Integer poll() {
        if (isEmpty())
            return null;
        else
            return pollFromNonEmptyArray();
    }

    private int pollFromNonEmptyArray() {
        int returnValue = values[1];
        swap(1, --nextIndex);
        bubbleDownValue(1);
        return returnValue;
    }

    private void bubbleDownValue(int position) {
        int firstChildIndex = getFirstChildIndex(position);
        int secondChildIndex = getSecondChildIndex(position);

        if (hasChildWithLowerValue(position, firstChildIndex, secondChildIndex))
            swapAndBubbleDown(position, getChildIndexWithMinimumValue(firstChildIndex, secondChildIndex));
    }

    private boolean hasChildWithLowerValue(int position, int firstChildIndex, int secondChildIndex) {
        boolean firstChildLessThan = hasChild(firstChildIndex) && values[firstChildIndex] < values[position];
        boolean secondChildLessThan = hasChild(secondChildIndex) && values[secondChildIndex] < values[position];

        return firstChildLessThan || secondChildLessThan;
    }

    private void swapAndBubbleDown(int position, int childIndex) {
        swap(childIndex, position);
        bubbleDownValue(childIndex);
    }

    private int getChildIndexWithMinimumValue(int firstChildIndex, int secondChildIndex) {
        if (hasOnlyFirstChild(firstChildIndex, secondChildIndex))
            return firstChildIndex;
        else if (hasOnlySecondChild(firstChildIndex, secondChildIndex))
            return secondChildIndex;
        else
            return values[firstChildIndex] < values[secondChildIndex] ? firstChildIndex : secondChildIndex;
    }

    private boolean hasOnlySecondChild(int firstChildIndex, int secondChildIndex) {
        return !hasChild(firstChildIndex) && hasChild(secondChildIndex);
    }

    private boolean hasOnlyFirstChild(int firstChildIndex, int secondChildIndex) {
        return hasChild(firstChildIndex) && !hasChild(secondChildIndex);
    }

    private boolean hasChild(int index) {
        return index != -1 && index < nextIndex;

    }

    private int getFirstChildIndex(int position) {
        int firstChildPosition = position * 2;
        return getIndexOrMinusOneIfOutOfBounds(firstChildPosition);
    }

    private int getSecondChildIndex(int position) {
        int firstChildPosition = position * 2 + 1;
        return getIndexOrMinusOneIfOutOfBounds(firstChildPosition);
    }

    private int getIndexOrMinusOneIfOutOfBounds(int firstChildPosition) {
        if (firstChildPosition < values.length)
            return firstChildPosition;
        else
            return -1;
    }
}
