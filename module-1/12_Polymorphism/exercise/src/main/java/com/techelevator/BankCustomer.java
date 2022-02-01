package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    //Method Variables

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<Accountable>();

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Methods

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    public void addAccount (Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        int totalAccountsValue = 0;
        for (Accountable a : accounts) {
            totalAccountsValue += a.getBalance();
        }
        if (totalAccountsValue >= 25000) {
            return true;
        }
            return false;
    }

}
