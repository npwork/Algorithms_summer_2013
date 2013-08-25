package coursera_stanford_2013.week6;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertTrue;

public abstract class AbstractHashTable implements HashTable {
    protected static final int DEFAULT_SIZE = 10;
    protected static final double DEFAULT_LOAD_FACTOR = 0.75;

    protected int size;
    protected double loadFactor;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected int getIndex(int hashCode) {
        return hashCode & (getBucketsSize() - 1);
    }

    protected void ensureNotNull(Integer key, Integer value) {
        ensureNotNull(key);
        ensureNotNull(value);
    }

    protected void ensureNotNull(Integer integer) {
        if (integer == null)
            throw new IllegalArgumentException("Null not supported");
    }

    protected void ensureLoadFactor() {
        if ((size / (double) getBucketsSize()) >= loadFactor)
            rehashBuckets(getBucketsSize() * 2);
    }

    protected abstract int getBucketsSize();

    protected abstract void rehashBuckets(int newSize);

    protected class KeyValue {
        public Integer key;
        public Integer value;
        public boolean deleted;

        public KeyValue(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
