package algorithms_book.order_statistics;

/**
 * Looks for min and max element in array using 3(n/2) comparisons
 * over simple brute force 2n - 2
 *
 * 1. odd = 3(n-1)/2 + 1 = 3n/2
 * 2. even = 1 + 3(n-2)/2 = 3n/2 - 2
 */
public class OptimizedMinMaxSearch {
    public static MinMaxValue getMinAndMax(int[] givenArray) {
        // general cases
        if (givenArray.length == 0)
            throw new IllegalArgumentException("Empty array not supported");

        if (givenArray.length == 1)
            return new MinMaxValue(givenArray[0]);

        if (givenArray.length == 2) {
            if (givenArray[0] > givenArray[1])
                return new MinMaxValue(givenArray[1], givenArray[0]);
            else
                return new MinMaxValue(givenArray[0], givenArray[1]);
        }

        // define min and max (depends on odd / even)
        int currentMin = 0;
        int currentMax = 0;
        int firstCompareElement = 0;

        if (isLengthEven(givenArray)) {
            if(givenArray[0] < givenArray[1]) {
                currentMin = givenArray[0];
                currentMax = givenArray[1];
            } else {
                currentMin = givenArray[1];
                currentMax = givenArray[0];
            }
            firstCompareElement = 2;
        } else {
            // length is odd
            currentMin = givenArray[0];
            currentMax = givenArray[0];
            firstCompareElement = 1;
        }


        int firstElement = 0;
        int secondElement = 0;
        for (int i = firstCompareElement; i < givenArray.length - 1; i += 2) {
            firstElement = givenArray[i];
            secondElement = givenArray[i + 1];

            if (firstElement > secondElement) {
                if (firstElement > currentMax)
                    currentMax = firstElement;

                if (secondElement < currentMin)
                    currentMin = secondElement;
            } else {
                if (firstElement < currentMin)
                    currentMin = firstElement;

                if (secondElement > currentMax)
                    currentMax = secondElement;
            }
        }


        return new MinMaxValue(currentMin, currentMax);
    }

    private static boolean isLengthEven(int[] givenArray) {
        return givenArray.length % 2 == 0;
    }

    public static class MinMaxValue {
        private int min;
        private int max;

        public MinMaxValue(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public MinMaxValue(int minMax) {
            this.min = minMax;
            this.max = minMax;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }
}
