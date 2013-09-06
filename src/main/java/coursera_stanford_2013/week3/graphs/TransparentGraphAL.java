package coursera_stanford_2013.week3.graphs;

public class TransparentGraphAL {
    public static GraphAL transparent(GraphAL graphAL) {
        GraphAL newGraphAL = cloneGraph(graphAL);

        for (Edge e : newGraphAL.getEdges())
            changeEdgeDirection(newGraphAL, e);

        return newGraphAL;
    }

    private static void changeEdgeDirection(GraphAL newGraphAL, Edge e) {
        Vertex fromVertex = newGraphAL.getVertex(e.getFrom());
        Vertex toVertex = newGraphAL.getVertex(e.getTo());

        removeAndAddFormAndToEdges(fromVertex, toVertex);
        changeEdgeFromAndToValues(e, fromVertex, toVertex);
    }

    private static void removeAndAddFormAndToEdges(Vertex fromVertex, Vertex toVertex) {
        fromVertex.removeEdge(toVertex);
        toVertex.addEdge(fromVertex);
    }

    private static void changeEdgeFromAndToValues(Edge e, Vertex fromVertex, Vertex toVertex) {
        e.setFrom(toVertex.getValue());
        e.setTo(fromVertex.getValue());
    }

    private static GraphAL cloneGraph(GraphAL graphAL) {
        GraphAL newGraphAL = null;
        try {
            newGraphAL = graphAL.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException(e);
        }
        return newGraphAL;
    }
}

