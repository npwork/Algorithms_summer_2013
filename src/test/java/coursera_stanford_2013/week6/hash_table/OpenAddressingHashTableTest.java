package coursera_stanford_2013.week6.hash_table;

import coursera_stanford_2013.week6.hash_table.OpenAddressingHashTable;
import coursera_stanford_2013.week6.hash_table.open_addressing.OpenAddressingType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class OpenAddressingHashTableTest extends AbstractHashTableTest {
    private OpenAddressingType openAddressingType;

    public OpenAddressingHashTableTest(OpenAddressingType openAddressingType) {
        this.openAddressingType = openAddressingType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameter() {
        Object[][] data = new Object[][]{
               {OpenAddressingType.LINEAR_PROBING},
                {OpenAddressingType.QUADRATIC_PROBING},
                {OpenAddressingType.DOUBLE_HASHING}
        };

        return Arrays.asList(data);
    }

    @Before
    public void setUp() throws Exception {
        hashTable = new OpenAddressingHashTable(openAddressingType);
    }

    @Test
    public void should_handle_resize() throws Exception {
        // given
        hashTable = new OpenAddressingHashTable(4, openAddressingType);
        should_retrieve_all_distinct_elements_that_were_added();
    }

}
