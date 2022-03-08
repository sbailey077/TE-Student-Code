package com.techelevator.timesheet.dao;

import com.techelevator.timesheet.model.EmployeeDetail;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
}
