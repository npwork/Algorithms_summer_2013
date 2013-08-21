package coursera_stanford_2013.week5.bst;

import coursera_stanford_2013.week5.BSTNode;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class MaxValueInSubTree extends AbstractBstTest {
    @Test
    public void should_set_max_in_sub_tree_if_all_elements_in_the_left() throws Exception {
        // given
        int[] givenArray = {5, 4, 3, 2, 1};
        addAllElementsToBst(givenArray);

        // when
        BSTNode<Integer> lowestElement = bst.search(1);

        // then
        lowestElement = assertAndGetParent(lowestElement, null);
        lowestElement = assertAndGetParent(lowestElement, 1);
        lowestElement = assertAndGetParent(lowestElement, 2);
        lowestElement = assertAndGetParent(lowestElement, 3);
        assertWithoutGettingParent(lowestElement, 4);
        assertEquals(Integer.valueOf(5), lowestElement.getKey());
    }

    @Test
    public void should_set_max_in_sub_tree_if_all_elements_in_the_right() throws Exception {
        // given
        int[] givenArray = {1, 2, 3, 4, 5};
        addAllElementsToBst(givenArray);

        // when
        BSTNode<Integer> lowestElement = bst.search(5);

        // then
        lowestElement = assertAndGetParent(lowestElement, null);
        lowestElement = assertAndGetParent(lowestElement, 5);
        lowestElement = assertAndGetParent(lowestElement, 5);
        lowestElement = assertAndGetParent(lowestElement, 5);
        assertWithoutGettingParent(lowestElement, 5);
        assertEquals(Integer.valueOf(1), lowestElement.getKey());
    }

    @Test
    public void should_set_max_in_sub_tree_if_all_elements_balanced() throws Exception {
        // given
        int[] givenArray = {3, 2, 5, 1, 6};
        addAllElementsToBst(givenArray);

        // when
        BSTNode<Integer> elementToCheckRoot = bst.search(3);
        BSTNode<Integer> elementToCheck1 = bst.search(2);
        BSTNode<Integer> elementToCheck2 = bst.search(5);

        // then
        assertWithoutGettingParent(elementToCheckRoot, 6);
        assertWithoutGettingParent(elementToCheck1, 1);
        assertWithoutGettingParent(elementToCheck2, 6);
    }

    // remove

    @Test
    @Ignore
    public void should_recompute_max_in_sub_tree_after_remove_if_all_items_in_left() throws Exception {
        // given
        int[] givenArray = {5, 4, 3, 2, 1};
        addAllElementsToBst(givenArray);

        // when
        bst.remove(3);
        BSTNode<Integer> lowestElement = bst.search(1);

        // then
        lowestElement = assertAndGetParent(lowestElement, null);
        lowestElement = assertAndGetParent(lowestElement, 1);
        lowestElement = assertAndGetParent(lowestElement, 2);
        assertWithoutGettingParent(lowestElement, 4);
        assertEquals(Integer.valueOf(5), lowestElement.getKey());
    }

    private BSTNode<Integer> assertAndGetParent(BSTNode<Integer> lowestElement, Integer expectedValue) {
        assertMaxInSubTree(expectedValue, lowestElement);
        lowestElement = lowestElement.getParent();
        return lowestElement;
    }

    private BSTNode<Integer> assertWithoutGettingParent(BSTNode<Integer> lowestElement, Integer expectedValue) {
        assertMaxInSubTree(expectedValue, lowestElement);
        return lowestElement;
    }

    private void assertMaxInSubTree(Integer expected, BSTNode<Integer> lowestElement) {
        assertEquals(expected, lowestElement.getMaxInSubTree());
    }
}
