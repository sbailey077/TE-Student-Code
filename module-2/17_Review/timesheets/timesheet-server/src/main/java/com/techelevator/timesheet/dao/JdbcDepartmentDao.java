package com.techelevator.timesheet.dao;

import com.techelevator.timesheet.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDepartmentDao implements DepartmentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcDepartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Department> list() {
        List<Department> departments = new ArrayList<Department>();
        String sql = "SELECT department.name AS department_name, users.username, employee.first_name, " +
                "employee.last_name FROM department " +
                "JOIN users ON department.manager_id = users.user_id " +
                "JOIN employee ON users.user_id = employee.user_id " +
                "ORDER BY department_name;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while(rows.next()) {
            departments.add(mapRowToDepartment(rows));
        }
        return departments;
    }

    private Department mapRowToDepartment(SqlRowSet rows) {
        Department department = new Department();
        department.setName( rows.getString("department_name") );
        department.setManagerFirstName( rows.getString("first_name") );
        department.setManagerLastName( rows.getString("last_name") );
        department.setManagerUsername( rows.getString("username") );
        return department;
    }

}

