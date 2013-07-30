package coursera_stanford_2013.week3.graphs;

import java.util.List;
import java.util.ListIterator;

public class RandomContraction {

    public static int minimumCut(UndirectedGraphAL graph) {
        List<Edge> edges = graph.getEdges();

        while (graph.vertexSize() > 2 && !edges.isEmpty()) {
            int index = (int) (Math.random() * edges.size());
            Edge edge = edges.get(index);

            graph.contract(edge.getFrom(), edge.getTo());

            removeSelfLoops(edges);
        }

        return edges.size();
    }

    private static void removeSelfLoops(List<Edge> edges) {
        ListIterator<Edge> edgeListIterator = edges.listIterator();

        while (edgeListIterator.hasNext()) {
            Edge item = edgeListIterator.next();
            if (item.getTo() == item.getFrom())
                edgeListIterator.remove();
        }

    }

    public static int minimumCutMinimumValue(UndirectedGraphAL originalGraph, int timesToCheck) {
        try {
            int minValue = Integer.MAX_VALUE;
            UndirectedGraphAL usingVersionOfGraph = originalGraph.clone();

            for (int i = 0; i < timesToCheck; ++i) {
                int thisLoopValue = minimumCut(usingVersionOfGraph);
                if(thisLoopValue < minValue)
                    minValue = thisLoopValue;

                usingVersionOfGraph = originalGraph.clone();

            }

            return minValue;
        } catch (CloneNotSupportedException e) {
            // can't happened since UndirectedGraphAL implements Comparable
            throw new RuntimeException("It's not possible but clone not supported");
        }
    }
}
