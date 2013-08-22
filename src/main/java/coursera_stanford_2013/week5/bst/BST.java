package coursera_stanford_2013.week5.bst;

public interface BST<E> {
    void add(E key);

    BSTNode<E> search(E key);

    boolean remove(E key);

    void toArray(E[] resultArray);

    E max();

    E min();

    int getSize();

    E successor(E key);

    E predecessor(E key);
}
