package coursera_stanford_2013.week5.bst.operations;

import coursera_stanford_2013.week5.BSTNode;
import coursera_stanford_2013.week5.bst.AbstractBstTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */
public class Search extends AbstractBstTest {
    @Test
    public void should_return_value_when_search() throws Exception {
        // given
        int parentValue = 100;
        int searchValue = 50;
        int leftValue = 25;
        int rightValue = 55;
        int[] givenArray = {parentValue, searchValue, leftValue, rightValue};
        addAllElementsToBst(givenArray);

        // when
        BSTNode searchResultNode = bst.search(searchValue);

        // then
        assertEquals(Integer.valueOf(searchValue), searchResultNode.getKey());
        assertEquals(Integer.valueOf(leftValue), searchResultNode.getLeft().getKey());
        assertEquals(Integer.valueOf(rightValue), searchResultNode.getRight().getKey());
        assertEquals(Integer.valueOf(parentValue), searchResultNode.getParent().getKey());
    }
}
