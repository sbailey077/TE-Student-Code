# Timesheets

## Users

All user have the password `password`

username [full name].  (MANAGER) indicates the user is a manager
* Department: Steam Release
    * jmatrix [Jenny Matrix] (MANAGER)
    * johnm [John Matrix]
    * bennett [Billy Bennett]
* Department: Funny Walks
    * tjones [Terry Jones] (MANAGER) 
    * mpalin [Michael Palin]
    * gchapman [Graham Chapman]
    * ccleveland [Carol Cleveland]
* Department: Logistics
    * jburton [Jack Burton] (MANAGER)
    * glaw [Gracie Law]
    * elee [Eddie Lee]

## departments view 

- Endpoint: `/departments`
- Access: Anyone
- Display Data: `department name,  manager name,  manager username`
- Sort Order: Department Name
- JSON

```
[
    {
        "name": "Funny Walks",
        "managerFirstName": "Terry",
        "managerLastName": "Jones",
        "managerUsername": "tjones"
    },
    {
        "name": "Logistics",
        "managerFirstName": "Jack",
        "managerLastName": "Burton",
        "managerUsername": "jburton"
    },
    {
        "name": "Steam Release",
        "managerFirstName": "Jenny",
        "managerLastName": "Matrix",
        "managerUsername": "jmatrix"
    }
]
```
- SQL Query
```
SELECT department.name AS department_name, users.username, employee.first_name, employee.last_name FROM department
JOIN users ON department.manager_id = users.user_id
JOIN employee ON users.user_id = employee.user_id
ORDER BY department_name;

```

## employee details view 

- Endpoint: `/employees`
- Access: Should only return data for the logged in user
- Display Data: `department, manager name, pay_rate`
- JSON

```
{
    "departmentName": "Steam Release",
    "managerFirstName": "Jenny",
    "managerLastName": "Matrix",
    "payRate": 51.0
}

```
- SQL Query
```
SELECT department.name AS department_name, manager_emp.first_name AS manager_first_name, manager_emp.last_name AS manager_last_name, employee.rate_per_hour  
FROM employee
JOIN department ON department.department_id = employee.department_id
JOIN users manager_user ON department.manager_id = manager_user.user_id
JOIN employee manager_emp ON manager_user.user_id = manager_emp.user_id
JOIN users emp_user ON employee.user_id = emp_user.user_id
WHERE emp_user.username = ?;
```

## department employee view 

- Endpoint: `/departments/{id}/employees`
- Access: Should only return employees for the logged in manager
- Display Data: `employee full name  pay_rate`
- Sort Order: Employee Last Name
- JSON

```
[
    {
        "firstName": "Billy",
        "lastName": "Bennett",
        "payRate": 31.15
    },
    {
        "firstName": "Jenny",
        "lastName": "Matrix",
        "payRate": 51.0
    },
    {
        "firstName": "John",
        "lastName": "Matrix",
        "payRate": 48.75
    }
]
```
- SQL Query
```
SELECT employee.first_name, employee.last_name, employee.rate_per_hour 
FROM department
JOIN employee ON employee.department_id = department.department_id
WHERE department.manager_id = (SELECT user_id FROM users WHERE username = ?)
ORDER BY employee.last_name;
```


## department employee view 

- Endpoint: `/employees/hours`
- Access: Should only return data for the currently logged in employee
- Display Data: `Date  task hours_billed  rate  total_billed`
- Sort Order: Date
- JSON

```
[
    {
        "date": "2020-02-28",
        "task": "Built release pipe",
        "hoursWorked": 8,
        "ratePerHour": 48.75,
        "totalBillable": 390.0
    },
    {
        "date": "2020-03-01",
        "task": "Created engagement presentation",
        "hoursWorked": 7,
        "ratePerHour": 48.75,
        "totalBillable": 341.25
    },
    {
        "date": "2020-03-02",
        "task": "Worked on Plan",
        "hoursWorked": 6,
        "ratePerHour": 48.75,
        "totalBillable": 292.5
    },
    {
        "date": "2020-03-03",
        "task": "Released Steam",
        "hoursWorked": 5,
        "ratePerHour": 48.75,
        "totalBillable": 243.75
    },
    {
        "date": "2020-03-04",
        "task": "Setup equipment",
        "hoursWorked": 5,
        "ratePerHour": 48.75,
        "totalBillable": 195.0
    }
]
```
- SQL Query
```
SELECT timesheet.date_worked, timesheet.description, timesheet.hours_worked, employee.rate_per_hour, round((hours_worked * rate_per_hour), 2) AS total_billable FROM timesheet
JOIN employee ON timesheet.employee_id = employee.employee_id
JOIN users ON employee.user_id = users.user_id
WHERE users.username = ? AND billable = true
ORDER BY date_worked;
```