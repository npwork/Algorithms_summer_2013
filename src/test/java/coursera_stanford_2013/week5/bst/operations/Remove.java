package coursera_stanford_2013.week5.bst.operations;

import coursera_stanford_2013.week5.bst.BSTNode;
import coursera_stanford_2013.week5.bst.AbstractBstTest;
import org.junit.Test;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: niko
 * Date: 8/20/13
 * Time: 8:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class Remove extends AbstractBstTest {
    @Test
    public void should_return_false_if_cant_find_item() throws Exception {
        // given
        int differentValue = 100500;
        int[] givenArray = {1, 2, 3};
        addAllElementsToBst(givenArray);

        // when
        boolean removeResult = bst.remove(differentValue);

        // then
        assertFalse(removeResult);
    }

    @Test
    public void should_remove_value_when_no_children_placing_in_the_root_position() throws Exception {
        // given
        int itemToDelete = 500;
        int[] givenArray = {itemToDelete};
        addAllElementsToBst(givenArray);

        // when
        boolean removeResult = bst.remove(itemToDelete);

        // then
        assertTrue(removeResult);
        assertItemDeleted(itemToDelete, givenArray);
    }

    @Test
    public void should_remove_value_when_no_children_placing_in_a_regular_position() throws Exception {
        // given
        int itemToDelete = 1000;
        int[] givenArray = {500, itemToDelete};
        addAllElementsToBst(givenArray);

        // when
        boolean removeResult = bst.remove(itemToDelete);

        // then
        assertTrue(removeResult);
        assertItemDeleted(itemToDelete, givenArray);
    }

    @Test
    public void should_remove_value_when_one_child_in_root_position() throws Exception {
        // given
        int itemToDelete = 100;
        int[] givenArray = {itemToDelete, 500};
        addAllElementsToBst(givenArray);

        // when
        boolean removeResult = bst.remove(itemToDelete);


        // then
        assertTrue(removeResult);
        assertItemDeleted(itemToDelete, givenArray);
    }

    @Test
    public void should_remove_value_when_one_child_in_regular_position() throws Exception {
        // given
        int itemToDelete = 100;
        int[] givenArray = {0, -1, itemToDelete, 500};
        addAllElementsToBst(givenArray);

        // when
        boolean removeResult = bst.remove(itemToDelete);

        // then
        assertTrue(removeResult);
        assertItemDeleted(itemToDelete, givenArray);
    }

    @Test
    public void should_remove_value_when_two_children_in_root_position() throws Exception {
        // given
        int itemToDelete = 0;
        int[] givenArray = {itemToDelete, -1, 1};
        addAllElementsToBst(givenArray);

        // when
        boolean removeResult = bst.remove(itemToDelete);

        // then
        assertTrue(removeResult);
        assertItemDeleted(itemToDelete, givenArray);
    }

    @Test
    public void should_remove_value_when_two_children_in_regular_position() throws Exception {
        // given
        int itemToDelete = 5;
        int[] givenArray = {0, -1, itemToDelete, 3, 10};
        addAllElementsToBst(givenArray);

        // when
        boolean removeResult = bst.remove(itemToDelete);

        // then
        assertTrue(removeResult);
        assertItemDeleted(itemToDelete, givenArray);
    }

    @Test
    public void should_remove_all_values_sequentially() throws Exception {
        // given
        int[] givenArray = {1, 2, 3, 4, 5};
        addAllElementsToBst(givenArray);

        // when
        for (int i : givenArray)
            assertTrue(bst.remove(i));

        // then
        assertEquals(0, bst.getSize());
    }

    @Test
    public void should_remove_all_values_opposite_to_sequentially() throws Exception {
        // given
        int[] givenArray = {5, 4, 3, 2, 1};
        addAllElementsToBst(givenArray);

        // when
        for (int i : givenArray)
            assertTrue(bst.remove(i));

        // then
        assertEquals(0, bst.getSize());
    }

    private void assertItemDeleted(int itemToDelete, int[] givenArray) {
        BSTNode search = bst.search(itemToDelete);

        assertNull(search);
        assertEquals(givenArray.length - 1, bst.getSize());
    }

}
