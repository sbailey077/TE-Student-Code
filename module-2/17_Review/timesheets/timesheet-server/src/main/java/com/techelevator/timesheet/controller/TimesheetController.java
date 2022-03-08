package com.techelevator.timesheet.controller;

import com.techelevator.timesheet.dao.DepartmentDao;
import com.techelevator.timesheet.dao.EmployeeDao;
import com.techelevator.timesheet.dao.JdbcEmployeeDao;
import com.techelevator.timesheet.model.Department;
import com.techelevator.timesheet.model.Employee;
import com.techelevator.timesheet.model.EmployeeDetail;
import com.techelevator.timesheet.model.TimesheetRecord;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class TimesheetController {

    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;

    public TimesheetController(DepartmentDao departmentDao, EmployeeDao employeeDao) {
        this.departmentDao = departmentDao;
        this.employeeDao = employeeDao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/departments", method= RequestMethod.GET)
    public List<Department> listDepartments() {
        return departmentDao.list();
    }

    @RequestMapping(path="/employees", method= RequestMethod.GET)
    public EmployeeDetail getDetailsForEmployee(Principal principal) {
        EmployeeDetail detail = employeeDao.getDetailsForEmployee(principal.getName());

        return detail;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/timesheets", method=RequestMethod.POST)
    public TimesheetRecord addTimesheetRecord(@RequestBody TimesheetRecord timesheetRecord, Principal principal) {
        return employeeDao.addTimesheetRecord(timesheetRecord, principal.getName());
    }


    @RequestMapping(path="/departments/{id}/employees", method=RequestMethod.GET)
    public List<Employee> getEmployeeDetailList(@PathVariable long id, Principal principal) {
        return employeeDao.listOfEmployeeDetail(principal.getName());
    }

}
