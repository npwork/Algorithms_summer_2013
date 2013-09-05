package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.Map;

/**
 * Depth-first search
 */
public class DFS {
    private final GraphAL graph;
    private final DFSForest forest;

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
        forest.setColor(vertex, Color.GRAY);
        for (Vertex adjacent : vertex.getAdjacent())
            if (forest.isWhite(adjacent))
                setParentAndVisitAdjacentVertex(vertex, adjacent);

        forest.setColor(vertex, Color.BLACK);
    }

    private void setParentAndVisitAdjacentVertex(Vertex vertex, Vertex adjacent) {
        forest.setParent(adjacent, vertex);
        dfsVisit(adjacent);
    }
}
