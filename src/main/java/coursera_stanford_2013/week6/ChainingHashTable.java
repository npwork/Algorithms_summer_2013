package coursera_stanford_2013.week6;

import java.util.LinkedList;

public class ChainingHashTable extends AbstractHashTable {
    private LinkedList<KeyValue>[] buckets;

    public ChainingHashTable() {
        this(DEFAULT_SIZE);
    }

    public ChainingHashTable(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public ChainingHashTable(int initialCapacity, double loadFactor) {
        buckets = (LinkedList<KeyValue>[]) new LinkedList[initialCapacity];
        this.loadFactor = loadFactor;
    }

    @Override
    public void put(Integer key, Integer value) {
        ensureNotNull(key, value);
        ensureLoadFactor();

        int index = getIndex(key.hashCode());
        KeyValue keyValue = new KeyValue(key, value);
        safelyAddElement(index, keyValue);
    }

    protected int getBucketsSize() {
        return buckets.length;
    }

    @Override
    protected void rehashBuckets(int newSize) {
        LinkedList<KeyValue>[] oldBuckets = buckets;
        buckets = (LinkedList<KeyValue>[]) new LinkedList[newSize];

        for (int i = 0; i < oldBuckets.length; ++i)
            if (oldBuckets[i] != null)
                putAllValuesFromOldBucket(oldBuckets[i]);

    }

    private void putAllValuesFromOldBucket(LinkedList<KeyValue> oldBucket) {
        for (KeyValue item : oldBucket)
            put(item.key, item.value);
    }

    private void safelyAddElement(int index, KeyValue keyValue) {
        LinkedList<KeyValue> bucket = getInitializedBucket(index);

        int elementIndex = getElementIndexByKey(bucket, keyValue.key);
        if (elementIndex != -1)
            updateBucketValue(keyValue, bucket, elementIndex);
        else
            addElementToBucket(keyValue, bucket);

    }

    private void updateBucketValue(KeyValue keyValue, LinkedList<KeyValue> bucket, int elementIndex) {
        bucket.get(elementIndex).value = keyValue.value;
    }

    private void addElementToBucket(KeyValue keyValue, LinkedList<KeyValue> bucket) {
        bucket.add(keyValue);
        size++;
    }

    private LinkedList<KeyValue> getInitializedBucket(int index) {
        if (notInitializedBucket(index))
            buckets[index] = new LinkedList<KeyValue>();
        return buckets[index];
    }

    private int getElementIndexByKey(LinkedList<KeyValue> bucket, Integer key) {
        for (int i = 0; i < bucket.size(); i++)
            if (bucket.get(i).key.equals(key))
                return i;
        return -1;
    }

    @Override
    public Integer get(Integer key) {
        int index = getIndex(key.hashCode());
        if (notInitializedBucket(index))
            return null;

        return getValueFromListOrNull(key, index);
    }

    private boolean notInitializedBucket(int index) {
        return buckets[index] == null;
    }

    private Integer getValueFromListOrNull(Integer key, int index) {
        for (KeyValue keyValue : buckets[index])
            if (keyValue.key.equals(key))
                return keyValue.value;
        return null;
    }

    @Override
    public Integer remove(Integer key) {
        ensureNotNull(key);

        int index = getIndex(key.hashCode());
        if (notInitializedBucket(index))
            return null;

        return removeElement(key, buckets[index]);
    }

    private Integer removeElement(Integer key, LinkedList<KeyValue> bucket) {
        for (int i = 0; i < bucket.size(); ++i)
            if (bucket.get(i).key.equals(key))
                return removeElementFromBucket(bucket, i);
        return null;
    }

    private Integer removeElementFromBucket(LinkedList<KeyValue> bucket, int i) {
        size--;
        return bucket.remove(i).value;
    }
}
