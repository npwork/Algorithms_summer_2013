package coursera_stanford_2013.week5.heap;

public class MinHeap extends AbstractHeap {
    @Override
    public void add(int value) {
        if (isEmpty())
            addRootElement(value);
        else
            addNonRootElement(value);
    }

    @Override
    protected boolean bubbleUpBrokeCondition(int position, int parentIndex) {
        return values[parentIndex] > values[position];
    }

    @Override
    public Integer poll() {
        if (isEmpty())
            return null;
        else
            return pollFromNonEmptyArray();
    }

    @Override
    protected void bubbleDownValue(int position) {
        int firstChildIndex = getFirstChildIndex(position);
        int secondChildIndex = getSecondChildIndex(position);

        if (hasChildWithLowerValue(position, firstChildIndex, secondChildIndex))
            swapAndBubbleDown(position, getChildIndexWithMinimumValue(firstChildIndex, secondChildIndex));
    }

    private int getChildIndexWithMinimumValue(int firstChildIndex, int secondChildIndex) {
        if (hasOnlyFirstChild(firstChildIndex, secondChildIndex))
            return firstChildIndex;
        else if (hasOnlySecondChild(firstChildIndex, secondChildIndex))
            return secondChildIndex;
        else
            return values[firstChildIndex] < values[secondChildIndex] ? firstChildIndex : secondChildIndex;
    }

    protected boolean hasChildWithLowerValue(int position, int firstChildIndex, int secondChildIndex) {
        boolean firstChildLessThan = hasChild(firstChildIndex) && values[firstChildIndex] < values[position];
        boolean secondChildLessThan = hasChild(secondChildIndex) && values[secondChildIndex] < values[position];

        return firstChildLessThan || secondChildLessThan;
    }

}
