package com.techelevator;

public class CreditCardAccount implements Accountable{

    //Method Variables
    private String accountHolder;
    private String accountNumber;
    private int debt = 0;


    @Override
    public int getBalance() {
        return this.getDebt() * -1;
    }

    //Constructor

    public CreditCardAccount (String accountHolder, String accountNumber) {
        this.debt = debt;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    //Getters

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }


    //Methods

    public int pay(int amountToPay) {
        this.debt -= amountToPay;
        return this.debt;
    }

    public int charge(int amountToCharge) {
        this.debt += amountToCharge;
        return this.debt;
    }
}
