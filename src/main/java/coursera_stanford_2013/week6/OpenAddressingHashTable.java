package coursera_stanford_2013.week6;

public class OpenAddressingHashTable extends AbstractHashTable {
    private final KeyValue DELETED_KEY_VALUE;
    private static int DEFAULT_STEP_SIZE = 1;
    private int stepSize;
    private KeyValue[] buckets;

    public OpenAddressingHashTable() {
        this(DEFAULT_SIZE);
    }

    public OpenAddressingHashTable(int size) {
        this(size, DEFAULT_LOAD_FACTOR, DEFAULT_STEP_SIZE);
    }

    public OpenAddressingHashTable(int size, double loadFactor, int stepSize) {
        this.buckets = new KeyValue[size];
        this.loadFactor = loadFactor;
        this.stepSize = stepSize;
        this.DELETED_KEY_VALUE = new KeyValue(null, null);
        this.DELETED_KEY_VALUE.deleted = true;
    }

    @Override
    public Integer get(Integer key) {
        for (int i = 0; i < buckets.length; ++i) {
            int index = getLinearProbingIndex(key.hashCode(), i);
            if (isBucketNotEmpty(index))
                return buckets[index].value;
        }
        return null;
    }

    @Override
    public void put(Integer key, Integer value) {
        ensureNotNull(key, value);
        ensureLoadFactor();

        KeyValue keyValue = new KeyValue(key, value);
        addElementToBucket(keyValue);
    }

    private void addElementToBucket(KeyValue keyValue) {
        for (int i = 0; i < buckets.length; ++i)
            if (addElementToBucketIfEmpty(keyValue, i))
                return;

        throw new IllegalStateException("Overflow!");
    }

    private boolean addElementToBucketIfEmpty(KeyValue keyValue, int i) {
        int index = getLinearProbingIndex(keyValue.key.hashCode(), i);
        return tryToAddIfEmpty(keyValue, index);
    }

    private boolean tryToAddIfEmpty(KeyValue keyValue, int index) {
        if (isEmptyBucket(index))
            return addElementToBucket(keyValue, index);
        else {
            return replaceIfKeysEquals(keyValue, index);
        }
    }

    private boolean replaceIfKeysEquals(KeyValue keyValue, int index) {
        if (hasEqualKeys(keyValue, index)) {
            buckets[index].value = keyValue.value;
            return true;
        }
        return false;
    }

    private boolean hasEqualKeys(KeyValue keyValue, int index) {
        return buckets[index].key.equals(keyValue.key);
    }

    private boolean addElementToBucket(KeyValue keyValue, int index) {
        buckets[index] = keyValue;
        size++;
        return true;
    }

    private boolean isEmptyBucket(int index) {
        return isEmptyBucket(buckets, index);
    }

    private boolean isEmptyBucket(KeyValue[] givenBuckets, int index) {
        return givenBuckets[index] == null || givenBuckets[index] == DELETED_KEY_VALUE;
    }

    private boolean isBucketNotEmpty(int index) {
        return !isEmptyBucket(index);
    }

    private boolean isBucketNotEmpty(KeyValue[] givenBuckets, int index) {
        return !isEmptyBucket(givenBuckets, index);
    }

    protected int getLinearProbingIndex(int hashCode, int index) {
        int i = (hashCode + index) % (getBucketsSize() - 1);
        return i;
    }

    protected int getBucketsSize() {
        return buckets.length;
    }

    @Override
    protected void rehashBuckets(int newSize) {
        KeyValue[] oldBuckets = buckets;
        buckets = new KeyValue[newSize];

        copyFromOldBucketsToNewBuckets(oldBuckets);
    }

    private void copyFromOldBucketsToNewBuckets(KeyValue[] oldBuckets) {
        for (int i = 0; i < oldBuckets.length; ++i)
            putOldValuesToNewBuckets(oldBuckets, i);
    }

    private void putOldValuesToNewBuckets(KeyValue[] oldBuckets, int i) {
        if (isBucketNotEmpty(oldBuckets, i))
            put(oldBuckets[i].key, oldBuckets[i].value);
    }

    @Override
    public Integer remove(Integer key) {
        for (int i = 0; i < buckets.length; ++i) {
            int index = getLinearProbingIndex(key.hashCode(), i);
            if (isBucketNotEmpty(index))
                return removeValue(index);
        }
        return null;
    }

    private Integer removeValue(int index) {
        Integer value = buckets[index].value;
        buckets[index] = DELETED_KEY_VALUE;
        size--;
        return value;
    }
}
