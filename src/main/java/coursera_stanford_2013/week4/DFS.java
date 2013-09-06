package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.LinkedList;
import java.util.Map;

/**
 * Depth-first search
 */
public class Dfs {
    protected GraphAL graph;
    protected Forest forest;
    private int time;

    public Dfs(GraphAL graph) {
        this.graph = graph;
        this.forest = new Forest(graph);
    }

    protected Dfs() {
    }

    public Forest computeForest() {
        for (Map.Entry<Integer, Vertex> vertexEntry : graph.getVertexMap().entrySet())
            visitVertexIfNotVisited(vertexEntry.getValue());

        return forest;
    }

    public Forest computeForest(LinkedList<Integer> verticesIterator) {
        while (!verticesIterator.isEmpty())
            visitVertexIfNotVisited(getVertexFromIterator(verticesIterator));

        return forest;
    }

    private Vertex getVertexFromIterator(LinkedList<Integer> verticesIterator) {
        return graph.getVertex(verticesIterator.pop());
    }

    private void visitVertexIfNotVisited(Vertex vertex) {
        if (forest.isWhite(vertex))
            dfsVisit(vertex);
    }

    private void dfsVisit(Vertex vertex) {
        setStartTimeAndMarkVertexAsInProgress(vertex);
        visitAllUnvisitedAdjacentVertices(vertex);
        setStopTimeAndMarkVertexAsVisited(vertex);
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
}
