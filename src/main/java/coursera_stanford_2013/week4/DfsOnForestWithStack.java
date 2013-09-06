package coursera_stanford_2013.week4;

import coursera_stanford_2013.week3.graphs.GraphAL;

public class DfsOnForestWithStack extends Dfs {
    public DfsOnForestWithStack(GraphAL graph) {
        super();
        this.graph = graph;
        this.forest = new ForestWithStack(graph);
    }

    @Override
    public ForestWithStack computeForest() {
        return (ForestWithStack) super.computeForest();
    }
}
