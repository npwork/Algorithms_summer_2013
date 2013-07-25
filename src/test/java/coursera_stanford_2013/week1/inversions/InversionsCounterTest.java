package coursera_stanford_2013.week1.inversions;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InversionsCounterTest {

    public static final String PATH_TO_FILE = "src/test/resources/coursera_stanford_2013/week1/test_input.txt";

    @Test
    public void inputFileExists() {
        File f = new File(PATH_TO_FILE);
        assertTrue(f.exists());
    }

    @Test
    public void fileHasValidData() throws Exception {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE);
        assertEquals(100000, ints.length);
    }

    @Test
    public void countNumberOfInversionsFromFile() throws IOException {
        int[] ints = IntegersFromFileReader.readArrayFromFile(PATH_TO_FILE);

        InversionsCounter inversionsCounterObj = new InversionsCounter();
        BigInteger count = inversionsCounterObj.countOfInversions(ints);
        System.out.println(count);
    }

    @Test
    public void simpleTestWithInversions() {
        // given
        int[] arr1 = {1, 4, 5, 2, 3, 6};

        // when
        InversionsCounter inversionsCounterObj = new InversionsCounter();
        BigInteger count = inversionsCounterObj.countOfInversions(arr1);

        // then
        assertEquals(4, count.intValue());
    }

    @Test
    public void simpleTestWithoutInversions() {
        // given
        int[] arr1 = {1, 2, 3, 4, 5, 6};

        // when
        InversionsCounter inversionsCounterObj = new InversionsCounter();
        BigInteger count = inversionsCounterObj.countOfInversions(arr1);

        // then
        assertEquals(0, count.intValue());
    }
}
