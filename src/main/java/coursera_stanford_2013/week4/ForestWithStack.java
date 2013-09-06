package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;

import java.util.LinkedList;

public class ForestWithStack extends Forest {
    private LinkedList<Integer> stopTimeVerticesStack = new LinkedList<Integer>();

    public ForestWithStack(GraphAL graph) {
        super(graph);
    }

    @Override
    public void setStopTime(int vertex, int time) {
        super.setStopTime(vertex, time);
        stopTimeVerticesStack.push(vertex);
    }

    public LinkedList<Integer> getStopTimeVerticesStack() {
        return stopTimeVerticesStack;
    }
}
