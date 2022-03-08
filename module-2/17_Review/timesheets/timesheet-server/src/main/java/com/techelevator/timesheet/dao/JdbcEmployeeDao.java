package com.techelevator.timesheet.dao;

import com.techelevator.timesheet.model.EmployeeDetail;
import com.techelevator.timesheet.model.TimesheetRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEmployeeDao implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public EmployeeDetail getDetailsForEmployee(String username) {
        EmployeeDetail detail = null;
        String sql = "SELECT department.name AS department_name, manager_emp.first_name AS manager_first_name, " +
                "manager_emp.last_name AS manager_last_name, employee.rate_per_hour " +
                "FROM employee " +
                "JOIN department ON department.department_id = employee.department_id " +
                "JOIN users manager_user ON department.manager_id = manager_user.user_id " +
                "JOIN employee manager_emp ON manager_user.user_id = manager_emp.user_id " +
                "JOIN users emp_user ON employee.user_id = emp_user.user_id " +
                "WHERE emp_user.username = ?;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, username);

        if (rows.next()) {
            detail = new EmployeeDetail();
            detail.setDepartmentName( rows.getString("department_name") );
            detail.setManagerFirstName( rows.getString( "manager_first_name") );
            detail.setManagerLastName( rows.getString( "manager_last_name" ) );
            detail.setPayRate( rows.getDouble( "rate_per_hour"));
        }
        return detail;
    }

    @Override
    public TimesheetRecord addTimesheetRecord(TimesheetRecord timesheet, String username) {

        long employeeId = getEmployeeIdFromUserName(username);

        String sql = "INSERT INTO timesheet(" +
                "employee_id, date_worked, hours_worked, billable, description) " +
                " VALUES (?, ?, ?, ?, ?) RETURNING timesheet_id;";

        Long id = jdbcTemplate.queryForObject(sql, Long.class, employeeId, timesheet.getDateWorked(), timesheet.getHoursWorked(),
                timesheet.isBillable(), timesheet.getDescription());

        timesheet.setTimesheetId(id);

        return timesheet;
    }

    private Long getEmployeeIdFromUserName(String username) {
        String sql = "SELECT employee_id FROM employee " +
                "JOIN users ON employee.user_id = users.user_id " +
                "WHERE users.username = ?";
        Long employeeId = jdbcTemplate.queryForObject(sql, Long.class, username);
        return employeeId;
    }

    @Override
    public List<EmployeeDetail> listOfEmployeeDetail(String userName) {
        List<EmployeeDetail> employeeDetailList = new ArrayList<>();

        String sql = "SELECT employee.first_name, employee.last_name, employee.rate_per_hour " +
                "FROM department " +
                "JOIN employee ON employee.department_id = department.department_id " +
                "WHERE department.manager_id = (SELECT user_id FROM users WHERE username = ?) " +
                "ORDER BY employee.last_name;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userName);

        while (rowSet.next()) {
            EmployeeDetail detail = new EmployeeDetail();
                detail.setDepartmentName( rowSet.getString("department_name") );
                detail.setManagerFirstName( rowSet.getString( "manager_first_name") );
                detail.setManagerLastName( rowSet.getString( "manager_last_name" ) );
                detail.setPayRate( rowSet.getDouble( "rate_per_hour"));
                employeeDetailList.add(detail);
        }
        return employeeDetailList;
    }
}
