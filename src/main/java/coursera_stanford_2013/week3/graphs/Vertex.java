package coursera_stanford_2013.week3.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vertex implements Cloneable {
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

    public List<Vertex> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(List<Vertex> adjacent) {
        this.adjacent = adjacent;
    }

    // for cycle resolution
    public Vertex customClone(Map<Integer, Vertex> alreadyCreatedVertexMap) {
        Vertex instance = new Vertex(value);
        List<Vertex> newAdjacent = new ArrayList<Vertex>();

        for (int i = 0; i < adjacent.size(); ++i) {
            Vertex vertex = adjacent.get(i);
            Vertex alreadyCreatedValue = alreadyCreatedVertexMap.get(vertex.getValue());
            if(alreadyCreatedValue == null) {
                alreadyCreatedVertexMap.put(vertex.getValue(), vertex);
                newAdjacent.add(vertex.customClone(alreadyCreatedVertexMap));
            } else {
                newAdjacent.add(alreadyCreatedValue);
            }
        }
        instance.setAdjacent(newAdjacent);
        return instance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;

        Vertex vertex = (Vertex) o;

        if (value != vertex.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + adjacent.hashCode();
        return result;
    }
}
