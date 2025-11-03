package Module_8.FutureValueApp;

public class FinanceCalculator {

    // a) 12 months in a year
    private static final int MONTHS_IN_YEAR = 12;

    // b) calculate future value from monthly payment, percent rate, and years
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        // c) months = years * MONTHS_IN_YEAR
        int months = years * MONTHS_IN_YEAR;

        // d) interestRate per Exhibit A: (1 + rate / 100)
        double interestRate = 1 + (rate / 100.0);

        // e) presentValue = monthlyPayment * months
        double presentValue = monthlyPayment * months;

        // f) futureValue per Exhibit B: presentValue * Math.pow(interestRate, months)
        double futureValue = presentValue * Math.pow(interestRate, months);

        // g) return it
        return futureValue;
    }
}

