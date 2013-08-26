package coursera_stanford_2013.week6.hash_table.open_addressing;

public class LinearProbing implements OpenAddressing {
    @Override
    public int getIndex(int hashCode, int index, int bucketsSize) {
        return (hashCode + index) % (bucketsSize - 1);
    }
}
