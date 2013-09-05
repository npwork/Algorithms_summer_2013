package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Depth-first search
 */
public class DFS {
    private final GraphAL graph;
    private final DFSForest forest;
    private int time;
    // Directed acyclic graph
    private List<Vertex> topologicallySortedDAG = new ArrayList<Vertex>();

    public DFS(GraphAL graph) {
        this.graph = graph;
        this.forest = new DFSForest(graph);
    }

    public DFSForest computeForest() {
        for (Map.Entry<Integer, Vertex> vertexEntry : graph.getVertexMap().entrySet())
            if (forest.isWhite(vertexEntry.getValue()))
                dfsVisit(vertexEntry.getValue());

        return forest;
    }

    private void dfsVisit(Vertex vertex) {
        setStartTimeAndMarkVertexAsInProgress(vertex);
        visitAllUnvisitedAdjacentVertices(vertex);
        setStopTimeAndMarkVertexAsVisited(vertex);
        topologicallySortedDAG.add(vertex);
    }

    private void setStopTimeAndMarkVertexAsVisited(Vertex vertex) {
        forest.setColor(vertex, Color.BLACK);
        forest.setStopTime(vertex, ++time);
    }

    private void visitAllUnvisitedAdjacentVertices(Vertex vertex) {
        for (Vertex adjacent : vertex.getAdjacent())
            if (forest.isWhite(adjacent))
                setParentAndVisitAdjacentVertex(vertex, adjacent);
    }

    private void setStartTimeAndMarkVertexAsInProgress(Vertex vertex) {
        forest.setStartTime(vertex, ++time);
        forest.setColor(vertex, Color.GRAY);
    }


    private void setParentAndVisitAdjacentVertex(Vertex vertex, Vertex adjacent) {
        forest.setParent(adjacent, vertex);
        dfsVisit(adjacent);
    }

    public List<Vertex> topologicalSort() {
        computeForest();
        return topologicallySortedDAG;
    }
}
