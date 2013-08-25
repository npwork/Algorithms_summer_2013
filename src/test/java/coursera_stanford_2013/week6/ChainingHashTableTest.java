package coursera_stanford_2013.week6;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertTrue;

public class ChainingHashTableTest extends AbstractHashTableTest {
    @Before
    public void setUp() throws Exception {
        hashTable = new ChainingHashTable();
    }

    @Test
    public void should_handle_resize() throws Exception {
        // given
        hashTable = new ChainingHashTable(2);
        should_retrieve_all_distinct_elements_that_were_added();
    }

}
