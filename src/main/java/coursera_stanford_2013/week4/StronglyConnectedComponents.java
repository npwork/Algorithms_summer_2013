package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;
import coursera_stanford_2013.week3.graphs.TransparentGraphAL;

public class StronglyConnectedComponents {

    private final GraphAL graphAL;

    public StronglyConnectedComponents(GraphAL graphAL) {
        this.graphAL = graphAL;
    }

    public void compute() {
        ForestWithStack graphForest = new DfsOnForestWithStack(graphAL).computeForest();
        GraphAL transparentGraph = TransparentGraphAL.transparent(graphAL);
        Forest forest = new Dfs(transparentGraph).computeForest(graphForest.getStopTimeVerticesStack());

        System.out.println("Hello");

    }
}
