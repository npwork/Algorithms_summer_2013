package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IntegersFromFileReader {

    public static int[] readArrayFromFile(String path, int expectedNumberOfElements) throws IOException {
        File f = new File(path);
        int[] resultArray = new int[expectedNumberOfElements];
        int i = 0;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String tmp = null;
        while((tmp = br.readLine()) != null && i < expectedNumberOfElements) {
            resultArray[i++] = Integer.parseInt(tmp);
        }

        return resultArray;
    }

}
