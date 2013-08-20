package coursera_stanford_2013.week5.bst.operations;

import coursera_stanford_2013.week5.bst.AbstractBstTest;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
public class Successor extends AbstractBstTest {
    @Test
    public void should_return_successor_of_the_value_if_has_right_node() throws Exception {
        // given
        int successorValue = 500;
        int successorSearchValue = 100;
        addAllElementsToBst(new int[]{0, 5, successorSearchValue, successorValue});

        // when
        int resultSuccessor = bst.successor(successorSearchValue);

        // then
        assertEquals(successorValue, resultSuccessor);
    }

    @Test
    public void should_return_successor_of_the_value() throws Exception {
        // given
        int successorSearchValue = 13;
        int successorValue = 15;
        addAllElementsToBst(new int[]{successorValue, 6, 7, successorSearchValue, 9});

        // when
        int resultSuccessor = bst.successor(successorSearchValue);

        // then
        assertEquals(successorValue, resultSuccessor);
    }

    @Test
    public void should_return_null_if_no_successor() throws Exception {
        // given
        addAllElementsToBst(new int[]{1, 2, 3, 4, 5});

        // when
        Integer resultPredecessor = bst.successor(5);

        // then
        assertNull(resultPredecessor);
    }
}
