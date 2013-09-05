package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth-first search
 */
public class BFS {

    public static BFSTree buildBfsTree(UndirectedGraphAL graphAL, int startFrom) {
        ensureGraphHasVertices(graphAL);
        BFSTree tree = new BFSTree(graphAL);
        return graphHasStartVertex(graphAL, startFrom) ? createBfsTree(graphAL, startFrom, tree) : tree;
    }

    private static boolean graphHasStartVertex(UndirectedGraphAL graphAL, int startFrom) {
        return graphAL.hasVertex(startFrom);
    }

    static BFSTree createBfsTree(UndirectedGraphAL graphAL, int startFrom, BFSTree tree) {
        tree.initStartPoint(startFrom);

        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(graphAL.getVertex(startFrom));

        while (!queue.isEmpty()) {
            Vertex element = queue.poll();
            for (Vertex v : element.getAdjacent()) {
                if (tree.isWhite(v)) {
                    tree.setColor(v, Color.GRAY);
                    tree.setDistance(v, tree.getDistanceTo(element) + 1);
                    tree.setParent(v, element);
                    queue.add(v);
                }
            }
            tree.setColor(element, Color.BLACK);
        }
        return tree;
    }

    private static void ensureGraphHasVertices(UndirectedGraphAL graphAL) {
        if (graphAL.vertexSize() == 0)
            throw new IllegalArgumentException();
    }
}
