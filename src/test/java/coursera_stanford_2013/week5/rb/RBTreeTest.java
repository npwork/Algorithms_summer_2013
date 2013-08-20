package coursera_stanford_2013.week5.rb;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class RBTreeTest {
    private RBTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new RBTree();
    }

    @Test
    public void should_perform_left_rotate() throws Exception {
        // given
        int fromValue = 5;
        int toValue = 7;
        int[] givenArray = {fromValue, 3, toValue, 6, 8};
        addAllElementsToBst(givenArray);

        // when
        tree.leftRotate(tree.search(fromValue), tree.search(toValue));
        RBNode newFromNode = tree.search(fromValue);
        RBNode newToNode = tree.search(toValue);

        // then
        assertEquals(givenArray.length, tree.getSize());
        assertNull(newToNode.getParent());
        assertEquals(newFromNode.getParent(), newToNode);
        assertEquals(Integer.valueOf(3), newFromNode.getLeft().getKey());
        assertEquals(Integer.valueOf(6), newFromNode.getRight().getKey());
        assertEquals(Integer.valueOf(8), newToNode.getRight().getKey());
    }

    @Test
    public void should_perform_right_rotate() throws Exception {
        // given
        int fromValue = 5;
        int toValue = 3;
        int[] givenArray = {fromValue, toValue, 1, 4, 7};
        addAllElementsToBst(givenArray);

        // when
        tree.rightRotate(tree.search(fromValue), tree.search(toValue));
        RBNode newFromNode = tree.search(fromValue);
        RBNode newToNode = tree.search(toValue);

        // then
        assertEquals(givenArray.length, tree.getSize());
        assertNull(newToNode.getParent());
        assertEquals(newFromNode.getParent(), newToNode);
        assertEquals(Integer.valueOf(4), newFromNode.getLeft().getKey());
        assertEquals(Integer.valueOf(7), newFromNode.getRight().getKey());
        assertEquals(Integer.valueOf(1), newToNode.getLeft().getKey());
    }

    protected void addAllElementsToBst(int[] givenArray) {
        for (int item : givenArray)
            tree.add(item);
    }
}
