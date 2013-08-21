package coursera_stanford_2013.week5.bst;

import coursera_stanford_2013.week5.BST;
import coursera_stanford_2013.week5.BSTImpl;
import org.junit.Before;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: niko
 * Date: 8/20/13
 * Time: 8:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractBstTest {
    protected BST<Integer> bst;

    private Comparator<Integer> integerComparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };

    @Before
    public void setUp() throws Exception {
        bst = new BSTImpl<Integer>(integerComparator);
    }

    protected void addAllElementsToBst(int[] givenArray) {
        for (int item : givenArray)
            bst.add(item);
    }
}
