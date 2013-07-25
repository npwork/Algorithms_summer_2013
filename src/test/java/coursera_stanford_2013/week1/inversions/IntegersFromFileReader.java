package week1.inversions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IntegersFromFileReader {

    public static int[] readArrayFromFile(String path) throws IOException {
        File f = new File(path);
        int[] resultArray = new int[100000];
        int i = 0;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String tmp = null;
        while((tmp = br.readLine()) != null) {
            resultArray[i++] = Integer.parseInt(tmp);
        }

        return resultArray;
    }

}
