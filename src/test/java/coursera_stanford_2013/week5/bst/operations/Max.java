package coursera_stanford_2013.week5.bst.operations;

import coursera_stanford_2013.week5.bst.AbstractBstTest;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class Max extends AbstractBstTest {
    @Test
    public void should_return_null_if_call_max_on_empty_tree() throws Exception {
        assertNull(bst.max());
    }

    @Test
    public void should_return_maximum_value() throws Exception {
        // given
        int givenMaximumValue = 500;
        addAllElementsToBst(new int[]{0, 5, 100, givenMaximumValue});

        // when
        int resultMaximumValue = bst.max();

        // then
        assertEquals(givenMaximumValue, resultMaximumValue);
    }
}
