package coursera_stanford_2013.week6.open_addressing;

public interface OpenAddressing {
    public int getIndex(int hashCode, int index, int bucketsSize);
}
