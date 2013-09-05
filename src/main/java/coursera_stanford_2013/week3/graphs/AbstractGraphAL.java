package coursera_stanford_2013.week3.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractGraphAL {
    protected Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();
    protected List<Edge> edges = new ArrayList<Edge>();

    public Vertex addVertex(int key) {
        Vertex retrieved = getVertex(key);
        if (retrieved != null)
            return retrieved;

        Vertex instance = new Vertex(key);
        vertexMap.put(key, instance);

        return instance;
    }

    public Vertex getVertex(int key) {
        return vertexMap.get(key);
    }

    public boolean hasVertex(int key) {
        return vertexMap.containsKey(key);
    }
}
