package com.company;

public class Main {

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        saver1.setBalance(2000.00);
        saver2.setBalance(3000.00);
        saver1.modifyInterestRate(.04);
        for(int i = 1; i <= 12; i++) {
            System.out.printf("saver1, month %d: $%.2f\t\tsaver2, month %d: $%.2f\n", i, saver1.calculateMonthlyInterest(), i, saver2.calculateMonthlyInterest());
        }
        System.out.print("\nWith 5%\n\n");
        saver1.modifyInterestRate(.05);

        System.out.printf("saver1 next month: $%.2f\t\tsaver2 next month: $%.2f", saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
    }
}
