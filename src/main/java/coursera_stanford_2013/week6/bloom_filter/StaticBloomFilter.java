package coursera_stanford_2013.week6.bloom_filter;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class StaticBloomFilter {
    private int[] PRIME_NUMBERS = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61};
    private int count_of_hash_functions = 3;
    public static final int DEFAULT_SIZE = 10000;
    private boolean[] filter = new boolean[DEFAULT_SIZE];
    private int size;

    public void put(int value) {
        for (int i = 0; i < count_of_hash_functions; ++i) {
            int index = getIndex(value, i);
            filter[index] = true;
        }
        size++;
    }

    private int getIndex(int value, int i) {
        int hashFunctionValue = getHashFunctionValue(value, i);
        return hashFunctionValue % filter.length;
    }

    private int getHashFunctionValue(int value, int i) {
        return new HashCodeBuilder(17, PRIME_NUMBERS[i]).append(value).toHashCode();
    }

    public boolean contains(int value) {
        if (isEmpty())
            throw new IllegalStateException("Empty Bloom filter");

        for (int i = 0; i < count_of_hash_functions; ++i) {
            int index = getIndex(value, i);
            if (!filter[index])
                return false;
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
