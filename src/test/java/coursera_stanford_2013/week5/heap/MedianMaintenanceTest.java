package coursera_stanford_2013.week5.heap;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class MedianMaintenanceTest {
    private MedianMaintenance medianMaintenance;

    @Before
    public void setUp() throws Exception {
        medianMaintenance = new MedianMaintenance();
    }

    @Test
    public void should_return_valid_medians() throws Exception {
        addValueAndAssertMedian(1, 1);
        addValueAndAssertMedian(2, 1);
        addValueAndAssertMedian(3, 2);
        addValueAndAssertMedian(4, 2);
        addValueAndAssertMedian(5, 3);
    }

    private void addValueAndAssertMedian(Integer addValue, Integer expectedMedium) {
        medianMaintenance.add(addValue);
        assertEquals(Integer.valueOf(expectedMedium), medianMaintenance.medium());
    }

    @Test
    public void should_return_null_if_no_elements() throws Exception {
        // given

        // when
        Integer mediumValue = medianMaintenance.medium();

        // then
        assertNull(mediumValue);
    }
}
