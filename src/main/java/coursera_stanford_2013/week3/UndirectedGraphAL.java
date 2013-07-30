package coursera_stanford_2013.week3;


import java.util.HashMap;
import java.util.Map;

/**
 * Undirected graph representation
 * Adjacency list
 */
public class UndirectedGraphAL {

    private Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();

    public Vertex addVertex(int key) {
        Vertex retrieved = getVertex(key);
        if(retrieved != null)
            return retrieved;

        Vertex instance = new Vertex(key);
        vertexMap.put(key, instance);

        return instance;
    }

    public Vertex getVertex(int key) {
        return vertexMap.get(key);
    }

    public boolean addEdge(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);

        if(vertexOne == null || vertexTwo == null)
            return false;

        vertexOne.addAdjacent(vertexTwo);
        vertexTwo.addAdjacent(vertexOne);
        return true;
    }

    public boolean addEdgeAndCreateVertex(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);

        if(vertexOne == null)
            vertexOne = addVertex(keyOne);

        if(vertexTwo == null)
            vertexTwo = addVertex(keyTwo);

        vertexOne.addAdjacent(vertexTwo);
        vertexTwo.addAdjacent(vertexOne);
        return true;
    }

    public boolean hasEdge(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);
        if(vertexOne == null || vertexTwo == null)
            return false;

        return vertexOne == null ? false : vertexOne.hasEdge(vertexTwo);
    }

    public boolean removeEdge(int key1, int key2) {
        Vertex vertexOne = vertexMap.get(key1);
        Vertex vertexTwo = vertexMap.get(key2);

        if(vertexOne == null || vertexTwo == null)
            return false;

        vertexOne.removeEdge(vertexTwo);
        vertexTwo.removeEdge(vertexOne);
        return true;
    }
}
