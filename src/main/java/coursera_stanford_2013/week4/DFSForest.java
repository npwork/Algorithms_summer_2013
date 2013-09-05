package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.HashMap;
import java.util.Map;

public class DFSForest {
    private Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
    private Map<Integer, Vertex> predecessorMap = new HashMap<Integer, Vertex>();

    public DFSForest(UndirectedGraphAL graph) {
        for (Map.Entry<Integer, Vertex> e : graph.getVertexMap().entrySet()) {
            colorMap.put(e.getKey(), Color.WHITE);
            predecessorMap.put(e.getKey(), null);
        }
    }

    public boolean containsVertex(int vertex) {
        return colorMap.containsKey(vertex);
    }

    public Vertex getParent(int vertexValue) {
        return predecessorMap.get(vertexValue);
    }

    public boolean isWhite(Vertex vertex) {
        return colorMap.get(vertex.getValue()) == Color.WHITE;
    }

    public void setColor(Vertex vertex, Color color) {
        colorMap.put(vertex.getValue(), color);
    }

    public void setParent(Vertex child, Vertex parent) {
        predecessorMap.put(child.getValue(), parent);
    }
}
