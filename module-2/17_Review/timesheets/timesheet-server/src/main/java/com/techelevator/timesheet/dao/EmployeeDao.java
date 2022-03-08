package com.techelevator.timesheet.dao;

import com.techelevator.timesheet.model.EmployeeDetail;
import com.techelevator.timesheet.model.TimesheetRecord;

import java.util.List;

public interface EmployeeDao {

    EmployeeDetail getDetailsForEmployee(String username);
    TimesheetRecord addTimesheetRecord(TimesheetRecord timesheet, String username);

    List<EmployeeDetail> listOfEmployeeDetail(String userName);
}
