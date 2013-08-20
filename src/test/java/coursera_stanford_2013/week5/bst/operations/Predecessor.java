package coursera_stanford_2013.week5.bst.operations;

import coursera_stanford_2013.week5.bst.AbstractBstTest;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class Predecessor extends AbstractBstTest {

    @Test
    public void should_return_predecessor_of_the_value_if_has_left_node() throws Exception {
        // given
        int expectedPredecessor = -2;
        int predecessorSearchValue = -1;
        addAllElementsToBst(new int[]{0, predecessorSearchValue, expectedPredecessor});

        // when
        int resultPredecessor = bst.predecessor(predecessorSearchValue);

        // then
        assertEquals(expectedPredecessor, resultPredecessor);
    }

    @Test
    public void should_return_predecessor_of_the_value() throws Exception {
        // given
        int predecessorSearchValue = 9;
        int expectedPredecessorValue = 7;
        addAllElementsToBst(new int[]{15, 6, expectedPredecessorValue, 13, predecessorSearchValue});

        // when
        int resultPredecessor = bst.predecessor(predecessorSearchValue);

        // then
        assertEquals(expectedPredecessorValue, resultPredecessor);
    }

    @Test
    public void should_return_null_if_no_predecessor() throws Exception {
        // given
        addAllElementsToBst(new int[]{1, 2, 3, 4, 5});

        // when
        Integer resultPredecessor = bst.predecessor(1);

        // then
        assertNull(resultPredecessor);
    }
}
