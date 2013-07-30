package coursera_stanford_2013.week3.graphs;

import java.util.List;

public class RandomContraction {

    public static int minimumCut(UndirectedGraphAL graph) {
        List<Edge> edges = graph.getEdges();

        while(graph.vertexSize() > 2 && !edges.isEmpty()) {
            int index = (int) (Math.random() * edges.size());
            Edge edge = edges.get(index);

            graph.contract(edge.getFrom(), edge.getTo());
        }

        return edges.size();  //To change body of created methods use File | Settings | File Templates.
    }
}
