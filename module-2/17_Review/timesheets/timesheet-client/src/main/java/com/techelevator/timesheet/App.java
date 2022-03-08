package com.techelevator.timesheet;

import com.techelevator.timesheet.model.*;
import com.techelevator.timesheet.services.AuthenticationService;
import com.techelevator.timesheet.services.ConsoleService;
import com.techelevator.timesheet.services.TimesheetService;

import java.util.List;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private TimesheetService timesheetService;

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        timesheetService = new TimesheetService(API_BASE_URL);
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {

            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        } else {
            // Set the Current User on the Service
            timesheetService.setUser(currentUser);
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                listDepartments();
            } else if (menuSelection == 2) {
                viewDetailsForEmployee();
            } else if (menuSelection == 3) {
                addRecordToTimesheet();
            } else if (menuSelection == 4) {
                viewDepartmentEmployees();
            } else if (menuSelection == 5) {
                viewEmployeeBillableHours();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void listDepartments() {
		List<Department> departmentList = timesheetService.getAllDepartments();
		consoleService.printDepartments(departmentList);
	}

	private void viewDetailsForEmployee() {
        EmployeeDetail details = timesheetService.getEmployeeDetailsForCurrentUser();
        consoleService.printEmployeeDetails(details);
	}

    private void addRecordToTimesheet() {
        Timesheet timesheet = consoleService.getNewTimeSheetRecordFromUser();
        timesheetService.addTimesheetRecord(timesheet);
    }

	private void viewDepartmentEmployees() {
		List<Employee> employeeDetails = timesheetService.departmentEmployeeView();
        if (employeeDetails != null) {
                consoleService.printEmployees(employeeDetails);

        } else {
            consoleService.printErrorMessage();
        }
	}

	private void viewEmployeeBillableHours() {
		// TODO Auto-generated method stub
		
	}


}
