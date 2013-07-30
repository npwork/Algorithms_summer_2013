package coursera_stanford_2013.week3;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int value;

    private List<Vertex> adjacent = new ArrayList<Vertex>();

    public void addAdjacent(Vertex vertex) {
        adjacent.add(vertex);
    }

    public Vertex(int value) {
        this.value = value;
    }

    public boolean hasEdge(Vertex vertex) {
        return adjacent.contains(vertex);
    }

    public boolean removeEdge(Vertex vertex) {
        return adjacent.remove(vertex);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
