package tasks.fifth;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberPredicateTest {

    @Test
    public void testDivisibleBy13() {
        NumberPredicate divisibleBy13 = (n) -> n % 13 == 0;

        assertTrue(divisibleBy13.test(13));
        assertTrue(divisibleBy13.test(26));
        assertTrue(divisibleBy13.test(39));

        assertFalse(divisibleBy13.test(11));
        assertFalse(divisibleBy13.test(24));
        assertFalse(divisibleBy13.test(37));

    }
}