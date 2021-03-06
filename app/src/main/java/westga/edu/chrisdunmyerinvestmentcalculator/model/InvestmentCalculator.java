package westga.edu.chrisdunmyerinvestmentcalculator.model;

/**
 * InvestmentCalculator class for performing investment calculations
 */
public class InvestmentCalculator {

    /**
     * The getFutureValue method calculates the amount available using the payment amount, rate of
     * return and number of payment periods to calculate.
     *
     * @param paymentPerPeriod - The amount being added per period
     * @param ratePerPeriod - The percentage rate of return
     * @param numberOfPeriods - The amount of periods the calculation should be performed
     * @return The future amount
     * @throws  IllegalArgumentException if the numberOfPeriods is less than 0
     */
    public double getFutureValue(double paymentPerPeriod, double ratePerPeriod, int numberOfPeriods) {
        if (numberOfPeriods < 0) {
            throw new IllegalArgumentException("The numberOfPeriods must be greater than 0.");
        }

        if ( ratePerPeriod == 0) {
           return  paymentPerPeriod * numberOfPeriods;
        }

        double numerator = 1;
        for (int i=0; i<numberOfPeriods; i++) {
            numerator = (1 + (ratePerPeriod/100)) * numerator;
        }
        numerator = numerator - 1;
        return paymentPerPeriod * (numerator / (ratePerPeriod/100));
    }
}

