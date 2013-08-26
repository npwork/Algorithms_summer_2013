package coursera_stanford_2013.week6.hash_table.open_addressing;

public class DoubleHashing implements OpenAddressing {
    @Override
    public int getIndex(int hashCode, int index, int bucketsSize) {
        return (hashCode + index * secondaryHash(hashCode)) % (bucketsSize - 1);
    }

    // From JDK HashMap
    int secondaryHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
