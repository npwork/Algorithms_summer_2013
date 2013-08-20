package coursera_stanford_2013.week5.bst.operations;

import coursera_stanford_2013.week5.bst.AbstractBstTest;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 11:33
 * To change this template use File | Settings | File Templates.
 */
public class ToArray extends AbstractBstTest {
    @Test
    public void should_print_tree_keys_in_order_tree_walk() throws Exception {
        // given
        int[] givenArray = {100, 50, 25, 55, 120, 125, 113};
        addAllElementsToBst(givenArray);

        // when
        Integer[] result = new Integer[bst.getSize()];
        bst.toArray(result);
        int[] resultArray = getIntArray(result);
        Arrays.sort(givenArray);

        // then
        assertTrue(Arrays.equals(givenArray, resultArray));
    }

    private int[] getIntArray(Integer[] result) {
        int[] resultArray = new int[result.length];
        for (int i = 0; i < result.length; ++i) {
            resultArray[i] = result[i];
        }
        return resultArray;
    }
}
