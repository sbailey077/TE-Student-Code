package com.techelevator.timesheet.dao;

import com.techelevator.timesheet.model.EmployeeDetail;
import com.techelevator.timesheet.model.TimesheetRecord;

public interface EmployeeDao {

    EmployeeDetail getDetailsForEmployee(String username);
    TimesheetRecord addTimesheetRecord(TimesheetRecord timesheet, String username);

}
