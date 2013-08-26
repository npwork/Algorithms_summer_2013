package coursera_stanford_2013.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NumbersFromFileReader {

    public static int[] readIntArrayFromFile(String path, int expectedNumberOfElements) throws IOException {
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

    public static long[] readLongArrayFromFile(String path, int expectedNumberOfElements) throws IOException {
        File f = new File(path);
        long[] resultArray = new long[expectedNumberOfElements];
        int i = 0;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String tmp = null;
        while((tmp = br.readLine()) != null && i < expectedNumberOfElements) {
            resultArray[i++] = Long.parseLong(tmp);
        }

        return resultArray;
    }

}
