package coursera_stanford_2013.week6;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertTrue;

public class ChainingHashTableTest {
    private HashTable hashTable;

    @Before
    public void setUp() throws Exception {
        hashTable = new ChainingHashTable();
    }

    @Test
    public void should_retrieve_all_distinct_elements_that_were_added() throws Exception {
        // given
        Integer[] givenValues = new Integer[]{100, 200, 300, 400, 500};
        addAllElements(givenValues);

        // when
        Integer[] retrievedValues = getAllElements(givenValues);

        // then
        assertTwoArraysAreEqual(givenValues, retrievedValues);
    }

    @Test
    public void should_handle_duplicate_elements() throws Exception {
        // given
        hashTable.put(0, 100);
        hashTable.put(0, 200);
        hashTable.put(0, 300);

        // when
        Integer result = hashTable.get(0);

        // then
        assertEquals(1, hashTable.size());
        assertEquals(Integer.valueOf(300), result);
    }

    @Test
    public void should_handle_resize() throws Exception {
        // given
        hashTable = new ChainingHashTable(2);
        should_retrieve_all_distinct_elements_that_were_added();
    }


    @Test
    public void should_return_null_if_no_element_found() throws Exception {
        // given
        // when
        Integer retrievedValue = hashTable.get(100500);

        // then
        assertNull(retrievedValue);
    }

    @Test
    public void should_return_value_when_removes() throws Exception {
        // given
        hashTable.put(1, 100);
        hashTable.put(2, 200);
        hashTable.put(3, 300);

        // when
        Integer result1 = hashTable.remove(1);
        Integer result2 = hashTable.remove(2);
        Integer result3 = hashTable.remove(3);

        // then
        assertEquals(Integer.valueOf(100), result1);
        assertEquals(Integer.valueOf(200), result2);
        assertEquals(Integer.valueOf(300), result3);
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
    }

    @Test
    public void should_return_null_when_removing_element_does_not_exists() throws Exception {
        // given
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());

        // when
        assertNull(hashTable.remove(100500));

        // then
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_pass_null_key() throws Exception {
        hashTable.put(null, 100500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_pass_null_value() throws Exception {
        hashTable.put(100500, null);
    }

    private void addAllElements(Integer[] givenValues) {
        for (int i = 0; i < givenValues.length; ++i)
            hashTable.put(i, givenValues[i]);
    }

    private Integer[] getAllElements(Integer[] givenValues) {
        Integer[] resultArray = new Integer[givenValues.length];
        for (int i = 0; i < givenValues.length; ++i)
            resultArray[i] = hashTable.get(i);
        return resultArray;
    }

    private void assertTwoArraysAreEqual(Integer[] givenValues, Integer[] retrievedValues) {
        for (int i = 0; i < givenValues.length; ++i)
            assertEquals(givenValues[i], retrievedValues[i]);
    }
}
