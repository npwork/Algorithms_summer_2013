package coursera_stanford_2013.week3.graphs;


/**
 * Undirected graph representation
 * Adjacency list
 */
public class UndirectedGraphAL extends AbstractGraphAL {

    public boolean addEdge(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);

        if (vertexOne == null || vertexTwo == null)
            return false;

        vertexOne.addEdge(vertexTwo);
        vertexTwo.addEdge(vertexOne);
        edges.add(new Edge(keyOne, keyTwo));
        return true;
    }

    public boolean removeEdge(int key1, int key2) {
        Vertex vertexOne = vertexMap.get(key1);
        Vertex vertexTwo = vertexMap.get(key2);

        if (vertexOne == null || vertexTwo == null)
            return false;

        vertexOne.removeEdge(vertexTwo);
        vertexTwo.removeEdge(vertexOne);
        edges.remove(new Edge(key1, key2));
        return true;
    }

    public int edgeSize() {
        // since we hold bidirectional relation between verticies
        return edges.size() / 2;
    }
}
