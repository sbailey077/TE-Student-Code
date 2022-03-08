package com.techelevator.timesheet.services;


import com.techelevator.timesheet.model.Department;
import com.techelevator.timesheet.model.EmployeeDetail;
import com.techelevator.timesheet.model.Timesheet;
import com.techelevator.timesheet.model.UserCredentials;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to Timesheets! *");
        System.out.println("*********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: View Departments");
        System.out.println("2: View your employee details");
        System.out.println("3: Add record to your timesheet");
        System.out.println("4: View your departments employees");
        System.out.println("5: View your billable hours");
        System.out.println("0: Exit");
        System.out.println();
    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }


    public void printDepartments(List<Department> departmentList) {

        System.out.printf("%-30s %-25s %-12s %n", "Department", "Manager Name", "Manager username");
        System.out.println("--------------------------------------------------------------------------------");

        for (Department department : departmentList) {
            System.out.printf("%-30s %-25s %-12s %n", department.getName(), department.getManagerFullName(),
                    department.getManagerUsername());
        }
    }

    public void printEmployeeDetails(EmployeeDetail employeeDetail) {

        System.out.println("Your employee details");
        System.out.println("---------------------------------");
        System.out.println("Department: " + employeeDetail.getDepartmentName());
        System.out.println("Manager: " + employeeDetail.getManagerFirstName() + " " + employeeDetail.getManagerLastName());
        System.out.printf("Pay Rate: $%6.2f %n", employeeDetail.getPayRate());
    }

    public Timesheet getNewTimeSheetRecordFromUser() {

        Timesheet timesheet = new Timesheet();

        System.out.println("Record timesheet item");
        System.out.print("Date (yyyy-mm-dd) >>> ");
        timesheet.setDateWorked(scanner.nextLine());
        System.out.print("Hours >>> ");
        timesheet.setHoursWorked( Double.parseDouble( scanner.nextLine() ));
        System.out.print("Task >>> ");
        timesheet.setDescription( scanner.nextLine() );
        System.out.print("Is Billable (Y/N) >>>");
        timesheet.setBillable( scanner.nextLine().equalsIgnoreCase("Y") );

        return timesheet;
    }
}
