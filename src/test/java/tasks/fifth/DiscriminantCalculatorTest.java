package tasks.fifth;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiscriminantCalculatorTest {

    @Test
    public void testDiscriminantCalculation() {
        DiscriminantCalculator  equation = (a, b, c) -> b * b - 4 * a * c;
        double a = 1.0;
        double b = 5.0;
        double c = 6.0;
        double expected = 1.0;
        double result = equation.calculate(a, b, c);
        assertEquals(expected, result, 0.0001);
    }
}