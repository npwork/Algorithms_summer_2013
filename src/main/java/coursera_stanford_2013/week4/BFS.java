package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Breadth-first search
 */
public class BFS {

    // Corman algorithm
    public static Result search(UndirectedGraphAL graphAL, int startPoint, int searchValue) {
        return null;
    }

    public static class Result {

        private Vertex vertex;
        private int vertexDistance;

        public Result(Vertex vertex, int vertexDistance) {
            this.vertex = vertex;
            this.vertexDistance = vertexDistance;
        }

        public int getVertexValue() {
            return vertex.getValue();
        }

        public int getVertexDistance() {
            return vertexDistance;
        }
    }

    public static Vertex isConnected(UndirectedGraphAL graph, int startVertex, int searchVertex) {
        Map<Integer, Vertex> alreadyExploredVertices = new HashMap<Integer, Vertex>();
        Queue<Integer> verticesToExplore = new LinkedList<Integer>();
        verticesToExplore.add(startVertex);

        while (!verticesToExplore.isEmpty()) {
            Integer vertexNameFromQueue = verticesToExplore.poll();
            Vertex vertex = graph.getVertex(vertexNameFromQueue);

            for (Vertex adjacentVertex : vertex.getAdjacent()) {
                if (foundExpectedVertex(searchVertex, adjacentVertex))
                    return adjacentVertex;

                processAdjacentVertex(alreadyExploredVertices, verticesToExplore, adjacentVertex);
            }
        }

        return null;
    }

    private static boolean foundExpectedVertex(int searchVertex, Vertex adjacentVertex) {
        return adjacentVertex.getValue() == searchVertex;
    }

    private static void processAdjacentVertex(Map<Integer, Vertex> alreadyMarkedVertices, Queue<Integer> queue, Vertex adjacentVertex) {
        if (isUnexplored(alreadyMarkedVertices, adjacentVertex)) {
            addVertexToExploreQueue(alreadyMarkedVertices, queue, adjacentVertex);
        }
    }

    private static void addVertexToExploreQueue(Map<Integer, Vertex> alreadyMarkedVertices, Queue<Integer> queue, Vertex adjacentVertex) {
        markAsExplored(alreadyMarkedVertices, adjacentVertex);
        queue.add(adjacentVertex.getValue());
    }

    private static Vertex markAsExplored(Map<Integer, Vertex> alreadyMarkedVertices, Vertex vertex) {
        return alreadyMarkedVertices.put(vertex.getValue(), vertex);
    }

    private static boolean isUnexplored(Map<Integer, Vertex> alreadyMarkedVertices, Vertex adjacentVertex) {
        return !alreadyMarkedVertices.containsKey(adjacentVertex.getValue());
    }
}
