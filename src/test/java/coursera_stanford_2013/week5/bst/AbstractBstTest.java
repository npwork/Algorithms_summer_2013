package coursera_stanford_2013.week5.bst;

import coursera_stanford_2013.week5.BST;
import org.junit.Before;

/**
 * Created with IntelliJ IDEA.
 * User: niko
 * Date: 8/20/13
 * Time: 8:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractBstTest {
    protected BST bst;

    @Before
    public void setUp() throws Exception {
        bst = new BST();
    }

    protected void addAllElementsToBst(int[] givenArray) {
        for (int item : givenArray)
            bst.add(item);
    }
}
