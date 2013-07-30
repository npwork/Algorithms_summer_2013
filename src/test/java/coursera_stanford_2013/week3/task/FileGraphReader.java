package coursera_stanford_2013.week3.task;

import coursera_stanford_2013.week3.graphs.UndirectedGraphAL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileGraphReader {

    public static UndirectedGraphAL readGraphFromFile(String fileName) throws IOException {
        File f = new File(fileName);

        UndirectedGraphAL graph = new UndirectedGraphAL();

        BufferedReader br = new BufferedReader(new FileReader(f));
        String tmp = null;
        while ((tmp = br.readLine()) != null) {
            String[] split = tmp.split("\t");
            int vertex = Integer.parseInt(split[0]);
            graph.addVertex(vertex);
            for(int i = 1; i < split.length; ++i) {
                graph.addEdgeAndCreateVertex(vertex, Integer.parseInt(split[i]));
            }
        }

        return graph;
    }
}
