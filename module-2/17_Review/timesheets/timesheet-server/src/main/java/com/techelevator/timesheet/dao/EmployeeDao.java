package com.techelevator.timesheet.dao;

import com.techelevator.timesheet.model.EmployeeDetail;

public interface EmployeeDao {

    EmployeeDetail getDetailsForEmployee(String username);

}
