package com.techelevator.timesheet.controller;

import com.techelevator.timesheet.dao.DepartmentDao;
import com.techelevator.timesheet.dao.EmployeeDao;
import com.techelevator.timesheet.model.Department;
import com.techelevator.timesheet.model.EmployeeDetail;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
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

}
