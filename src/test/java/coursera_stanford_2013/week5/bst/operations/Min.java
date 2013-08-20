package coursera_stanford_2013.week5.bst.operations;

import coursera_stanford_2013.week5.bst.AbstractBstTest;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */
public class Min extends AbstractBstTest {
    @Test
    public void should_return_minimum_value() throws Exception {
        // given
        int givenMinimumValue = 0;
        addAllElementsToBst(new int[]{givenMinimumValue, 5, 100, 50});

        // when
        int resultMinimumValue = bst.min();

        // then
        assertEquals(givenMinimumValue, resultMinimumValue);
    }

    @Test
    public void should_return_null_if_call_min_on_empty_tree() throws Exception {
        assertNull(bst.min());
    }
}
