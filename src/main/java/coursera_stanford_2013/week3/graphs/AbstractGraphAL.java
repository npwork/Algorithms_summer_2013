package coursera_stanford_2013.week3.graphs;

import java.util.*;

public abstract class AbstractGraphAL implements GraphAL {
    protected Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();
    protected List<Edge> edges = new ArrayList<Edge>();

    @Override
    public Vertex addVertex(int key) {
        Vertex retrieved = getVertex(key);
        if (retrieved != null)
            return retrieved;

        Vertex instance = new Vertex(key);
        vertexMap.put(key, instance);

        return instance;
    }

    @Override
    public Vertex getVertex(int key) {
        return vertexMap.get(key);
    }

    @Override
    public boolean hasVertex(int key) {
        return vertexMap.containsKey(key);
    }

    @Override
    public Vertex removeVertex(int key) {
        Vertex vertex = vertexMap.get(key);
        return vertex == null ? null : removeNotNullVertex(key, vertex);
    }

    @Override
    public Vertex removeNotNullVertex(int key, Vertex vertex) {
        removeEdgesFromAdjacentVertices(vertex);

        vertexMap.remove(key);
        return vertex;
    }

    @Override
    public void removeEdgesFromAdjacentVertices(Vertex vertex) {
        for (Vertex v : vertex.getAdjacent())
            v.removeEdge(vertex);
    }

    @Override
    public boolean addEdgeAndCreateVertex(int keyOne, int keyTwo) {
        createVertexIfNotExists(keyOne);
        createVertexIfNotExists(keyTwo);

        addEdge(keyOne, keyTwo);
        return true;
    }

    @Override
    public void changeEdge(Edge fromEdge, Edge toEdge) {
        removeEdge(fromEdge.getFrom(), fromEdge.getTo());
        addEdgeAndCreateVertex(toEdge.getFrom(), toEdge.getTo());
    }

    @Override
    public Vertex createVertexIfNotExists(int key) {
        Vertex retrievedVertex = vertexMap.get(key);
        return retrievedVertex != null ? retrievedVertex : addVertex(key);
    }

    @Override
    public boolean hasEdge(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);
        if (vertexOne == null || vertexTwo == null)
            return false;

        return vertexOne == null ? false : vertexOne.hasEdge(vertexTwo);
    }

    @Override
    public boolean hasNoEdge(int keyOne, int keyTwo) {
        return !hasEdge(keyOne, keyTwo);
    }

    @Override
    public int countOfEdges(int keyOne, int keyTwo) {
        Vertex vertexOne = vertexMap.get(keyOne);
        Vertex vertexTwo = vertexMap.get(keyTwo);
        if (vertexOne == null || vertexTwo == null)
            return 0;

        int counter = 0;
        for (Vertex v : vertexOne.getAdjacent())
            if (v.getValue() == keyTwo)
                counter++;

        return counter;
    }

    @Override
    public int contract(int key1, int key2) {
        Vertex vertex1 = vertexMap.get(key1);
        Vertex vertex2 = vertexMap.get(key2);
        if (vertex1 == null || vertex2 == null)
            throw new IllegalArgumentException("No vertex");

        List<Vertex> adjacentOfSecondVertex = vertex2.getAdjacent();
        switchAllEdgesFromOneVertexToAnother(vertex1, vertex2, adjacentOfSecondVertex);
        removeVertex(key2);

        return key1;
    }

    @Override
    public void switchAllEdgesFromOneVertexToAnother(Vertex vertex1, Vertex vertex2, List<Vertex> adjacentOfSecondVertex) {
        while (!adjacentOfSecondVertex.isEmpty()) {
            Vertex vertexIterableItem = adjacentOfSecondVertex.get(0);
            Edge edgeToRemove = new Edge(vertex2.getValue(), vertexIterableItem.getValue());
            Edge edgeToAdd = new Edge(vertex1.getValue(), vertexIterableItem.getValue());

            changeEdge(edgeToRemove, edgeToAdd);
        }
    }

    @Override
    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public void setVertexMap(Map<Integer, Vertex> vertexMap) {
        this.vertexMap = vertexMap;
    }

    @Override
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public Map<Integer, Vertex> getVertexMap() {
        return vertexMap;
    }

    @Override
    public int vertexSize() {
        return vertexMap.size();
    }

    @Override
    public UndirectedGraphAL clone() throws CloneNotSupportedException {
        UndirectedGraphAL instance = new UndirectedGraphAL();
        instance.setEdges(cloneListOfEdges());
        instance.setVertexMap(cloneVertexMap());
        return instance;
    }

    private List<Edge> cloneListOfEdges() throws CloneNotSupportedException {
        List<Edge> listOfEdges = new ArrayList<Edge>(edges.size() + 1);
        for (int i = 0; i < edges.size(); ++i)
            listOfEdges.add(edges.get(i).clone());
        return listOfEdges;
    }

    private Map<Integer, Vertex> cloneVertexMap() {
        Map<Integer, Vertex> newVertexMap = new HashMap<Integer, Vertex>();

        for (Map.Entry<Integer, Vertex> vertexEntry : vertexMap.entrySet())
            newVertexMap.put(vertexEntry.getKey(), vertexEntry.getValue().customClone(newVertexMap));

        return newVertexMap;
    }

    @Override
    public void deleteAllVerticesAndEdges() {
        vertexMap.clear();
        edges.clear();
    }
}
