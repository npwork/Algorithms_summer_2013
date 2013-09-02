package coursera_stanford_2013.week3.graphs;


import java.util.*;

/**
 * Undirected graph representation
 * Adjacency list
 */
public class UndirectedGraphAL implements Cloneable {

    private Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();
    private List<Edge> edges = new ArrayList<Edge>();

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

    public Vertex removeVertex(int key) {
        Vertex vertex = vertexMap.get(key);
        if (vertex == null)
            return null;

        for (Vertex v : vertex.getAdjacent()) {
            v.removeEdge(vertex);
        }

        vertexMap.remove(key);
        return vertex;
    }

    public int contract(int key1, int key2) {
        Vertex vertex1 = vertexMap.get(key1);
        Vertex vertex2 = vertexMap.get(key2);
        if (vertex1 == null || vertex2 == null)
            throw new IllegalArgumentException("No vertex");

        List<Vertex> adjacentOfSecondVertex = vertex2.getAdjacent();
        // can't modify during iteration
        while (!adjacentOfSecondVertex.isEmpty()) {
            Vertex vertexIterableItem = adjacentOfSecondVertex.get(0);
            Edge edgeToRemove = new Edge(vertex2.getValue(), vertexIterableItem.getValue());
            Edge edgeToAdd = new Edge(vertex1.getValue(), vertexIterableItem.getValue());

            changeEdge(edgeToRemove, edgeToAdd);
        }

        removeVertex(key2);

        return key1;
    }

    public void changeEdge(Edge fromEdge, Edge toEdge) {
        removeEdge(fromEdge.getFrom(), fromEdge.getTo());
        addEdgeAndCreateVertex(toEdge.getFrom(), toEdge.getTo());
    }

    public boolean addEdge(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);

        if (vertexOne == null || vertexTwo == null)
            return false;

        vertexOne.addAdjacent(vertexTwo);
        vertexTwo.addAdjacent(vertexOne);
        edges.add(new Edge(keyOne, keyTwo));
        return true;
    }

    public boolean addEdgeAndCreateVertex(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);

        if (vertexOne == null)
            vertexOne = addVertex(keyOne);

        if (vertexTwo == null)
            vertexTwo = addVertex(keyTwo);

        vertexOne.addAdjacent(vertexTwo);
        vertexTwo.addAdjacent(vertexOne);
        edges.add(new Edge(keyOne, keyTwo));
        return true;
    }

    public boolean hasEdge(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);
        if (vertexOne == null || vertexTwo == null)
            return false;

        return vertexOne == null ? false : vertexOne.hasEdge(vertexTwo);
    }

    public int countOfEdges(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);
        if (vertexOne == null || vertexTwo == null)
            return 0;

        int counter = 0;
        for (Vertex v : vertexOne.getAdjacent()) {
            if (v.getValue() == keyTwo)
                counter++;

        }

        return counter;
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

    public int vertexSize() {
        return vertexMap.size();
    }

    public int edgeSize() {
        // since we hold bidirectional relation between verticies
        return edges.size() / 2;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setVertexMap(Map<Integer, Vertex> vertexMap) {
        this.vertexMap = vertexMap;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Map<Integer, Vertex> getVertexMap() {
        return vertexMap;
    }

    @Override
    public UndirectedGraphAL clone() throws CloneNotSupportedException {
        UndirectedGraphAL instance = new UndirectedGraphAL();
        // edges
        List<Edge> listOfEdges = new ArrayList<Edge>();
        for (int i = 0; i < edges.size(); ++i) {
            listOfEdges.add(edges.get(i).clone());
        }
        instance.setEdges(listOfEdges);

        // vertexMap
        Map<Integer, Vertex> newVertexMap = new HashMap <Integer, Vertex>();

        Iterator<Map.Entry<Integer, Vertex>> iterator = vertexMap.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, Vertex> next = iterator.next();
            newVertexMap.put(next.getKey(), next.getValue().customClone(newVertexMap));
        }

        instance.setVertexMap(newVertexMap);
        return instance;
    }
}
