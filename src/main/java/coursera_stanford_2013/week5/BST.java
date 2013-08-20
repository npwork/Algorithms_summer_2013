package coursera_stanford_2013.week5;

public interface BST {
    void add(Integer key);

    boolean remove(Integer key);

    BSTNode search(Integer key);

    Integer predecessor(int key);

    Integer successor(int key);

    void toArray(Integer[] resultArray);

    Integer max();

    Integer min();

    int getSize();
}
