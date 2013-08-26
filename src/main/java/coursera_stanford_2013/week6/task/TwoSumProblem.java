package coursera_stanford_2013.week6.task;

import java.util.*;

public class TwoSumProblem {
    private static long before = 0;

    public static long countOfSums(long[] longsFromFile, int from, int to) {
        LinkedHashMap<Long, Long> map = addAllElementsToMap(longsFromFile);

        return countNumberOfSums(from, to, map);
    }

    private static long countNumberOfSums(int from, int to, LinkedHashMap<Long, Long> map) {
        startTimer();
        long counter = 0;
        for (long i = from; i <= to; ++i) {
            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                long key = entry.getKey();
                if (i != key && map.containsKey(i - key))
                    counter++;
            }
        }
        stopTimerAndPrintMessage("Look for [" + from + "; " + to + "]");
        return counter;
    }

    private static LinkedHashMap<Long, Long> addAllElementsToMap(long[] longsFromFile) {
        startTimer();
        LinkedHashMap<Long, Long> map = new LinkedHashMap<Long, Long>(1000001);
        for (long l : longsFromFile) {
            map.put(l, l);
        }
        System.out.println(map.size());
        stopTimerAndPrintMessage("Add all to map: ");
        return map;
    }

    private static void stopTimerAndPrintMessage(String stringParameter) {
        System.out.println(stringParameter + (System.currentTimeMillis() - before));
    }

    private static void startTimer() {
        before = System.currentTimeMillis();
    }
}
