package coursera_stanford_2013.week3.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vertex implements Cloneable {
    private static int objectCounter = 0;

    private final int id;
    private int value;

    private List<Vertex> adjacent = new ArrayList<Vertex>();


    public Vertex(int value) {
        this.value = value;
        this.id = objectCounter++;
    }

    public Vertex(int value, int id) {
        this.value = value;
        this.id = id;
    }

    public void addAdjacent(Vertex vertex) {
        adjacent.add(vertex);
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

    public List<Vertex> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(List<Vertex> adjacent) {
        this.adjacent = adjacent;
    }

    // for cycle resolution
    public Vertex customClone(Map<Integer, Vertex> alreadyCreatedVertexMap) {
        Vertex instance = new Vertex(value, id);
        List<Vertex> newAdjacent = new ArrayList<Vertex>();

        for (int i = 0; i < adjacent.size(); ++i) {
            Vertex vertex = adjacent.get(i);
            Vertex alreadyCreatedValue = alreadyCreatedVertexMap.get(vertex.getValue());
            if (alreadyCreatedValue == null) {
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

        if (id != vertex.id) return false;
        if (value != vertex.value) return false;
        if (!adjacent.equals(vertex.adjacent)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + adjacent.hashCode();
        return result;
    }
}
