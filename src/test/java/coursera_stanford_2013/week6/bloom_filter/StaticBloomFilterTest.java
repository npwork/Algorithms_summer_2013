package coursera_stanford_2013.week6.bloom_filter;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class StaticBloomFilterTest {
    private StaticBloomFilter bloomFilter;

    @Before
    public void setUp() throws Exception {
        bloomFilter = new StaticBloomFilter();
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_if_trying_to_call_contains_on_empty_filter() throws Exception {
        bloomFilter.contains(1);
    }

    @Test
    public void should_support_return_true_on_contains_operation_if_value_present() throws Exception {
        // given
        bloomFilter.put(1);
        bloomFilter.put(10);
        bloomFilter.put(100);
        bloomFilter.put(1000);

        // when
        assertTrue(bloomFilter.contains(1));
        assertTrue(bloomFilter.contains(10));
        assertTrue(bloomFilter.contains(100));
        assertTrue(bloomFilter.contains(1000));
    }

    @Test
    public void should_support_return_false_on_contains_operation_if_value_absent() throws Exception {
        // given
        bloomFilter.put(1);
        bloomFilter.put(10);
        bloomFilter.put(100);

        // when
        assertFalse(bloomFilter.contains(2));
        assertFalse(bloomFilter.contains(105));
    }
}
