package com.techelevator;

public class BankAccount {

    //Method Variables

    private String accountHolderName;
    private String accountNumber;
    private int balance = 0;

    //Getters

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    //Constructor

    public BankAccount (String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount (String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Methods

    public int deposit (int amountToDeposit) {
        balance += amountToDeposit;
        return balance;
    }

    public int withdraw (int amountToWithdraw) {
        balance -= amountToWithdraw;
        return balance;
    }

}
