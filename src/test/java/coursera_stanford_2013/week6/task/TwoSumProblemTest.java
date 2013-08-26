package coursera_stanford_2013.week6.task;

import coursera_stanford_2013.util.NumbersFromFileReader;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

@Ignore
public class TwoSumProblemTest {
    private static final String FILE_NAME =
            "src" + File.separator +
            "test" + File.separator +
            "resources" + File.separator +
            "coursera_stanford_2013" + File.separator +
            "week6" + File.separator +
            "integers_for_two_sum.txt";

    @Test
    public void should_return_all_count_of_two() throws Exception {
        long[] longsFromFile = NumbersFromFileReader.readLongArrayFromFile(FILE_NAME, 1000000);

        long count = TwoSumProblem.countOfSums(longsFromFile, -10000, 10000);
        System.out.println(count);

    }
}
