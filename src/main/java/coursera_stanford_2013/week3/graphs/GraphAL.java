package coursera_stanford_2013.week3.graphs;

import java.util.List;
import java.util.Map;

public interface GraphAL extends Cloneable {
    Vertex addVertex(int key);

    Vertex getVertex(int key);

    boolean hasVertex(int key);

    Vertex removeVertex(int key);

    Vertex removeNotNullVertex(int key, Vertex vertex);

    void removeEdgesFromAdjacentVertices(Vertex vertex);

    boolean addEdgeAndCreateVertex(int keyOne, int keyTwo);

    boolean addEdge(int keyOne, int keyTwo);

    void changeEdge(Edge fromEdge, Edge toEdge);

    Vertex createVertexIfNotExists(int key);

    boolean removeEdge(int key1, int key2);

    boolean hasEdge(int keyOne, int keyTwo);

    boolean hasNoEdge(int keyOne, int keyTwo);

    int countOfEdges(int keyOne, int keyTwo);

    int contract(int key1, int key2);

    void switchAllEdgesFromOneVertexToAnother(Vertex vertex1, Vertex vertex2, List<Vertex> adjacentOfSecondVertex);

    List<Edge> getEdges();

    void setVertexMap(Map<Integer, Vertex> vertexMap);

    void setEdges(List<Edge> edges);

    Map<Integer, Vertex> getVertexMap();

    int vertexSize();

    int edgeSize();

    GraphAL clone() throws CloneNotSupportedException;

    void deleteAllVerticesAndEdges();
}
