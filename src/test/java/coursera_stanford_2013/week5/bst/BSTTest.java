package coursera_stanford_2013.week5.bst;

import coursera_stanford_2013.week5.BST;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BSTTest extends AbstractBstTest {
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
        BST.BSTNode searchResultNode = bst.search(searchValue);

        // then
        assertEquals(Integer.valueOf(searchValue), searchResultNode.getKey());
        assertEquals(Integer.valueOf(leftValue), searchResultNode.getLeft().getKey());
        assertEquals(Integer.valueOf(rightValue), searchResultNode.getRight().getKey());
        assertEquals(Integer.valueOf(parentValue), searchResultNode.getParent().getKey());
    }


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

    @Test
    public void should_return_successor_of_the_value_if_has_right_node() throws Exception {
        // given
        int successorSearchValue = 100;
        int successorValue = 500;
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
    public void should_return_predecessor_of_the_value() throws Exception {
    }

    private int[] getIntArray(Integer[] result) {
        int[] resultArray = new int[result.length];
        for (int i = 0; i < result.length; ++i) {
            resultArray[i] = result[i];
        }
        return resultArray;
    }
}
