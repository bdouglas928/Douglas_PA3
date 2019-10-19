package com.company;

public class SavingsAccount {
    static double annualInterestRate;
    private double savingsBalance;
    public void setBalance(double num) {
        savingsBalance = num;
    }
    public double calculateMonthlyInterest() {
        savingsBalance += (savingsBalance * annualInterestRate) / 12.0;
        return savingsBalance;
    }
    public void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }
}
