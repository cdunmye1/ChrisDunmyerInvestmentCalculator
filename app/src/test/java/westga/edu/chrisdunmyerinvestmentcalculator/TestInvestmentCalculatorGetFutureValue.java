package westga.edu.chrisdunmyerinvestmentcalculator;

import org.junit.Test;

import westga.edu.chrisdunmyerinvestmentcalculator.model.InvestmentCalculator;

import static org.junit.Assert.*;

/**
 * Tests the getFutureValue method of the InvestmentCalculator class
 */
public class TestInvestmentCalculatorGetFutureValue {
    @Test
    public void testGetFutureValueWhenUsingNormalWholeNumbers() {
        InvestmentCalculator calculator = new InvestmentCalculator();
        assertEquals(11463.88, calculator.getFutureValue(1000, 3, 10), .1);
    }
}
