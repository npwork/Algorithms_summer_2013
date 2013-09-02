package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.Map;

public class ConnectedComponents {

    public static int connectedComponentsCount(UndirectedGraphAL graphAL) {
        Map<Integer, Vertex> vertexMap = graphAL.getVertexMap();
        BFSTree tree = new BFSTree(graphAL);

        int count = 0;
        for (Map.Entry<Integer, Vertex> entry : vertexMap.entrySet()) {
            Vertex vertex = vertexMap.get(entry.getKey());
            if (isUnexplored(tree, vertex)) {
                BFS.createBfsTree(graphAL, vertex.getValue(), tree);
                count++;
            }
        }
        return count;
    }

    private static boolean isUnexplored(BFSTree tree, Vertex vertex) {
        return tree.isWhite(vertex);
    }

}
