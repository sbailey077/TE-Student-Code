package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.RowSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Long id) {
		Department department = null;
		String sql = "SELECT department_id, name " + "FROM department " + "WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

		if (results.next()) {
			department = mapRowToDepartment(results);
		}
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<Department>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT department_id, name FROM department;");

		while (results.next()) {
			departments.add(mapRowToDepartment(results));
		}
		return departments;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql = "UPDATE department " + "SET name = ? " + "WHERE department_id = ?;";

		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());
	}

	private Department mapRowToDepartment(SqlRowSet rowSet) {
		Department departmentFromCurrentRow = new Department();

		departmentFromCurrentRow.setId( rowSet.getLong("department_id"));
		departmentFromCurrentRow.setName( rowSet.getString("name"));

		return departmentFromCurrentRow;
	}

}
