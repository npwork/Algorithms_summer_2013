package coursera_stanford_2013.week6.hash_table.open_addressing;

public class QuadraticProbing implements OpenAddressing {
    private static final Integer C_1 = 3;
    private static final Integer C_2 = 5;

    @Override
    public int getIndex(int hashCode, int index, int bucketsSize) {
        return (hashCode + C_1 * index + C_2 * indexSquare(index)) % (bucketsSize - 1);
    }

    private int indexSquare(int index) {
        return index * index;
    }
}
