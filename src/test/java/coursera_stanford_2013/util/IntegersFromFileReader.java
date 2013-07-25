package coursera_stanford_2013.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
