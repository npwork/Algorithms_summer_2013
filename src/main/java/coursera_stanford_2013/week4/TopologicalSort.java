package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopologicalSort {
    private final GraphAL graph;
    private final Forest forest;
    // Directed acyclic graph
    private List<Vertex> topologicallySortedDAG = new ArrayList<Vertex>();

    public TopologicalSort(GraphAL graph) {
        this.graph = graph;
        this.forest = new Forest(graph);
    }

    public List<Vertex> sort(GraphAL graph) {
        for (Map.Entry<Integer, Vertex> vertexEntry : graph.getVertexMap().entrySet())
            if (forest.isWhite(vertexEntry.getValue()))
                topologicalSortDfsVisit(vertexEntry.getValue());
        return topologicallySortedDAG;
    }


    private void topologicalSortDfsVisit(Vertex vertex) {
        visitVertex(vertex);
        topologicallySortedDAG.add(vertex);
    }

    private void visitVertex(Vertex vertex) {
        forest.setColor(vertex, Color.GRAY);
        visitAllUnvisitedAdjacentVertices(vertex);
        forest.setColor(vertex, Color.BLACK);
    }

    private void visitAllUnvisitedAdjacentVertices(Vertex vertex) {
        for (Vertex adjacent : vertex.getAdjacent())
            if (forest.isWhite(adjacent))
                topologicalSortDfsVisit(adjacent);
    }
}