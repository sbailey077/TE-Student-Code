package com.techelevator;

public class CheckingAccount extends BankAccount {

   public CheckingAccount (String accountHolderName, String accountNumber) {
       super (accountHolderName, accountNumber);
   }

   public CheckingAccount (String accountHolderName, String accountNumber, int balance) {
       super (accountHolderName, accountNumber, balance);
   }

   @Override
    public int withdraw (int amountToWithdraw) {
       if (getBalance() <= 0 && amountToWithdraw >= (100 + getBalance())) {
           return getBalance();
       } else if (getBalance() < 0 && getBalance() >= -100) {
           amountToWithdraw += 10;
       }
        super.withdraw(amountToWithdraw);
       return getBalance();
   }
}


