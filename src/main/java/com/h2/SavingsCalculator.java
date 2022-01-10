package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    private float SumOfCredits() {
        float sum = 0.0f;
        for (float credit : credits) {
            sum += credit;
        }
        return sum;
    }

    private float SumOfDebits() {
        float sum = 0.0f;
        for (float debit : debits) {
            sum += debit;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float Calculate() {
        return SumOfCredits() - SumOfDebits();
    }

    public static void main(String[] args) {
        final String[] creditsAsString = args[0].split(",");
        final String[] debitsAsString = args[1].split(",");

        final float[] credits = new float[creditsAsString.length];
        for (int i=0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        final float[] debits = new float[debitsAsString.length];
        for (int i=0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        final SavingsCalculator calculator = new SavingsCalculator(debits, credits);
        float netSavings = calculator.Calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
}
