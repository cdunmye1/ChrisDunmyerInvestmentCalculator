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

    @Test
     public void testGetFutureValueWhenNumberOfPeriodsIs0() {
        InvestmentCalculator calculator = new InvestmentCalculator();
        assertEquals(0, calculator.getFutureValue(1000, 3, 0), .1);
    }

    @Test
    public void testGetFutureValueWhenRatePerPeriodIs0() {
        InvestmentCalculator calculator = new InvestmentCalculator();
        assertEquals(10000, calculator.getFutureValue(1000, 0, 10), .1);
    }

    @Test
    public void testGetFutureValueWhenPaymentPerPeriodIsZero() {
        InvestmentCalculator calculator = new InvestmentCalculator();
        assertEquals(0, calculator.getFutureValue(0, 5, 10), .1);
    }

    @Test
     public void testGetFutureValueWhenRatePerPeriodIsNegative() {
        InvestmentCalculator calculator = new InvestmentCalculator();
        assertEquals(80252.61, calculator.getFutureValue(10000, -5, 10), .1);
    }

    @Test(expected = IllegalArgumentException.class)
     public void testGetFutureValueWhenNumberOfPaymentPeriodsIs0() {
        InvestmentCalculator calculator = new InvestmentCalculator();
        calculator.getFutureValue(10000, 5, -1);
    }

    @Test
    public void testGetFutureValueWhenPaymentPerPeriodAndRatePerPeriodAreNotWholeNumbers() {
        InvestmentCalculator calculator = new InvestmentCalculator();
        assertEquals(11384.47, calculator.getFutureValue(957.54, 3.789, 10), .1);
    }
}
