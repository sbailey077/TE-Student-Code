package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee;");

		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT employee_id, department_id, last_name, first_name, birth_date, hire_date " +
				"FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");

		while (results.next()) {
			Employee employeeFromCurrentRow = mapRowToEmployee(results);
			employees.add(employeeFromCurrentRow);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee " +
				"JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		while(results.next()) {
			Employee employeeFromCurrentRow = mapRowToEmployee(results);
			employees.add(employeeFromCurrentRow);
		}

		return employees;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) " +
				"VALUES (?, ?)";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT employee.employee_id, employee.department_id, employee.last_name, employee.first_name, employee.birth_date, employee.hire_date FROM EMPLOYEE " +
				"LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"LEFT JOIN project ON project_employee.project_id = project.project_id " +
				"WHERE project.project_id IS NULL;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Employee employeeFromCurrentRow = mapRowToEmployee(results);
			employees.add(employeeFromCurrentRow);
		}
		return employees;
	}

	private Employee mapRowToEmployee (SqlRowSet rowSet) {
		Employee employeeFromCurrentRow = new Employee();

		employeeFromCurrentRow.setId( rowSet.getLong("employee_id"));
		employeeFromCurrentRow.setDepartmentId(rowSet.getLong("department_id"));
		employeeFromCurrentRow.setFirstName(rowSet.getString("first_name"));
		employeeFromCurrentRow.setLastName( rowSet.getString("last_name"));
		employeeFromCurrentRow.setBirthDate( rowSet.getDate("birth_date").toLocalDate());
		employeeFromCurrentRow.setHireDate( rowSet.getDate("hire_date").toLocalDate());

		return employeeFromCurrentRow;
	}


}
