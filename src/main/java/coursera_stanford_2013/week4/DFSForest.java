package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.Vertex;

import java.util.HashMap;
import java.util.Map;

public class DFSForest {
    private Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
    private Map<Integer, Vertex> predecessorMap = new HashMap<Integer, Vertex>();
    private Map<Integer, Integer> startTimeMap = new HashMap<Integer, Integer>();
    private Map<Integer, Integer> stopTimeMap = new HashMap<Integer, Integer>();


    public DFSForest(GraphAL graph) {
        for (Map.Entry<Integer, Vertex> e : graph.getVertexMap().entrySet()) {
            colorMap.put(e.getKey(), Color.WHITE);
            predecessorMap.put(e.getKey(), null);
        }
    }

    public boolean containsVertex(int vertex) {
        return colorMap.get(vertex) != null && colorMap.get(vertex).equals(Color.BLACK);
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

    public void setStartTime(int vertex, int time) {
        startTimeMap.put(vertex, time);
    }

    public void setStartTime(Vertex vertex, int time) {
        setStartTime(vertex.getValue(), time);
    }

    public int getStartTime(int vertex) {
        return startTimeMap.get(vertex);
    }

    public void setStopTime(int vertex, int time) {
        stopTimeMap.put(vertex, time);
    }

    public void setStopTime(Vertex vertex, int time) {
        setStopTime(vertex.getValue(), time);
    }

    public int getStopTime(int vertex) {
        return stopTimeMap.get(vertex);
    }

}
