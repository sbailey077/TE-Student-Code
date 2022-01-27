package com.techelevator;

public class Employee {

    /*
    Member Variables:
        employeeId - int - gets the employee id number
        firstName - string - states the employee's first name
        lastName - string - states the employee's last name
        fullName (derived) - string - states the employee's full name using firstName and lastName
        department - string - sets the employee's department
        annualSalary - double - states the employee's annual salary
     */
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    /*
    Getters and Setters
     */

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

   public void setDepartment (String department) {
        this.department = department;
   }

    /*
    Constructor
     */
    public Employee (int employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }

    public String getFullName() {
        return lastName + ", " + firstName;
    }

    public void raiseSalary (double percent) {
        annualSalary += (annualSalary * (percent / 100));
    }


}




