package util;

public class RandomArrayGenerator {
    public static int[] generateArray(int length, int maxValue) {
        int[] resultArray = new int[length];
        for (int i = 0; i < length; ++i) {
            resultArray[i] = (int) (Math.random() * maxValue);
        }

        return resultArray;
    }
}
