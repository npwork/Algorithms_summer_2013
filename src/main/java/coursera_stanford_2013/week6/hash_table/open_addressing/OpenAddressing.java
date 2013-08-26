package coursera_stanford_2013.week6.hash_table.open_addressing;

public interface OpenAddressing {
    int getIndex(int hashCode, int index, int bucketsSize);
}
