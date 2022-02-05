package com.techelevator.exceptions.accounts;

import java.util.Scanner;

public class BankApplication {

    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Account account = new CheckingAccount();

        System.out.println("Welcome to the Java Blue bank");
        showBalance(account);
        System.out.println();

        System.out.print("Amount to withdraw >>> ");
        String userInput = input.nextLine();

        int amount = Integer.parseInt(userInput);

        account.withdraw(amount);

        System.out.println(amount + " was withdrawn");
        showBalance(account);


    }

    private static void showBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
    }

}
