package coursera_stanford_2013.week6;

import org.junit.Before;
import org.junit.Test;

public class OpenAddressingHashTableTest extends AbstractHashTableTest {
    @Before
    public void setUp() throws Exception {
        hashTable = new OpenAddressingHashTable();
    }

    @Test
    public void should_handle_resize() throws Exception {
        // given
        hashTable = new OpenAddressingHashTable(4);
        should_retrieve_all_distinct_elements_that_were_added();
    }

}
