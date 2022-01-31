package com.techelevator;

public class SavingsAccount extends BankAccount {

    public SavingsAccount (String accountHolderName, String accountNumber) {
       super (accountHolderName, accountNumber);
    }

    public SavingsAccount (String accountHolderName, String accountNumber, int balance) {
        super (accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw (int amountToWithdraw) {
        if (getBalance() - amountToWithdraw < 150) {
            amountToWithdraw += 2;
        }
        if (getBalance() - amountToWithdraw < 0) {
            return getBalance();
        }
        super.withdraw(amountToWithdraw);
                return getBalance();
    }

}
