package coursera_stanford_2013.week5.heap;

public interface Heap {
    void add(int value);

    Integer poll();

    int getSize();

    boolean isEmpty();
}
