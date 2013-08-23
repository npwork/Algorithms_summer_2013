package coursera_stanford_2013.week6;

public interface HashTable {
    Integer get(Integer key);

    void put(Integer key, Integer value);

    int size();

    boolean isEmpty();

    Integer remove(Integer key);
}
