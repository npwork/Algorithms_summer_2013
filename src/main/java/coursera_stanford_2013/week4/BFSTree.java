package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.HashMap;
import java.util.Map;

public class BFSTree {
    private Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
    private Map<Integer, Vertex> predecessorMap = new HashMap<Integer, Vertex>();
    private Map<Integer, Integer> distanceMap = new HashMap<Integer, Integer>();

    public BFSTree(GraphAL graphAL) {
        initDefaultValuesToMaps(graphAL);
    }

    public BFSTree(UndirectedGraphAL graphAL, int startFrom) {
        this(graphAL);
        initStartPoint(startFrom);
    }

    public void initStartPoint(int startFrom) {
        colorMap.put(startFrom, Color.GRAY);
        distanceMap.put(startFrom, 0);
    }

    private void initDefaultValuesToMaps(GraphAL graphAL) {
        for (Map.Entry<Integer, Vertex> e : graphAL.getVertexMap().entrySet()) {
            colorMap.put(e.getKey(), Color.WHITE);
            distanceMap.put(e.getKey(), null);
            predecessorMap.put(e.getKey(), null);
        }
    }

    public int getDistanceTo(Vertex to) {
        return distanceMap.get(to.getValue());
    }

    public Integer getDistanceTo(int to) {
        return distanceMap.get(to);
    }

    public Integer getPredecessor(int element) {
        return predecessorMap.get(element) == null ? null : predecessorMap.get(element).getValue();
    }

    public boolean isWhite(Vertex vertex) {
        return colorMap.get(vertex.getValue()) == Color.WHITE;
    }

    public void setColor(Vertex vertex, Color color) {
        colorMap.put(vertex.getValue(), color);
    }

    public void setDistance(Vertex element, int distance) {
        distanceMap.put(element.getValue(), distance);
    }

    public void setParent(Vertex element, Vertex parentElement) {
        predecessorMap.put(element.getValue(), parentElement);
    }
}
