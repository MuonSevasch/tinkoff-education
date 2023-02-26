package tasks.fifth;

import org.junit.Test;

import static org.junit.Assert.*;

public class SummableTest {

    @Test
    public void testSumIntegers() {
        Summable<Integer> sumIntegers = (a, b) -> a + b;
        assertEquals(Integer.valueOf(10), sumIntegers.sum(5, 5));
    }

    @Test
    public void testSumFloats() {
        Summable<Float> sumFloats = (a, b) -> a + b;
        assertEquals(Float.valueOf(10.0f), sumFloats.sum(5.0f, 5.0f));
    }

    @Test
    public void testSumDoubles() {
        Summable<Double> sumDoubles = (a, b) -> a + b;
        assertEquals(Double.valueOf(10.0), sumDoubles.sum(5.0, 5.0));
    }
}