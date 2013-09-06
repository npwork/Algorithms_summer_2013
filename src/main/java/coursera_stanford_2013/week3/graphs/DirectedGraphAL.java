package coursera_stanford_2013.week3.graphs;

/**
 * Directed graph representation
 * Adjacency list
 */
public class DirectedGraphAL extends AbstractGraphAL {

    public boolean addEdge(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);

        if (vertexOne == null || vertexTwo == null)
            return false;

        vertexOne.addEdge(vertexTwo);
        edges.add(new Edge(keyOne, keyTwo));
        return true;
    }

    public boolean removeEdge(int key1, int key2) {
        Vertex vertexOne = vertexMap.get(key1);
        Vertex vertexTwo = vertexMap.get(key2);

        if (vertexOne == null || vertexTwo == null)
            return false;

        vertexOne.removeEdge(vertexTwo);
        edges.remove(new Edge(key1, key2));
        return true;
    }

    public int edgeSize() {
        return edges.size();
    }
}
