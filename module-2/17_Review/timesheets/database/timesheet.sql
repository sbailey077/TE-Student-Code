BEGIN TRANSACTION;

DROP TABLE IF EXISTS department, employee, timesheet, users CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_users PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE department (
	department_id serial,
	manager_id bigint not null,
	name varchar(40) UNIQUE NOT NULL,
	CONSTRAINT PK_department PRIMARY KEY (department_id),
	CONSTRAINT FK_deparment_user FOREIGN KEY (manager_id) REFERENCES users(user_id)
);

CREATE TABLE employee (
	employee_id serial,
	user_id bigint not null,
	department_id int,
	first_name varchar(20) NOT NULL,
	last_name varchar(30) NOT NULL,
	rate_per_hour numeric(8,2) NOT NULL,
	CONSTRAINT PK_employee PRIMARY KEY (employee_id),
	CONSTRAINT FK_employee_department FOREIGN KEY (department_id) REFERENCES department(department_id),
	CONSTRAINT FK_employee_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE timesheet (
    timesheet_id serial,
    employee_id int NOT NULL,
    date_worked date NOT NULL,
    hours_worked numeric(5,2) NOT NULL,
    billable boolean NOT NULL,
    description varchar(100),
    CONSTRAINT PK_timesheet PRIMARY KEY (timesheet_id),
    CONSTRAINT FK_timesheet_employee FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

-- CREATE DEPARTMENTS

-- 1001  (MANAGER USER), 1002, 1003
INSERT INTO public.users(username, password_hash) 
VALUES ('jmatrix', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
	('johnm', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
	('bennett', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');

-- 1 (DEPARTMENT)
INSERT INTO public.department(manager_id, name)VALUES (1001, 'Steam Release'); 

-- 1, 2, 3
INSERT INTO public.employee( user_id, department_id, first_name, last_name, rate_per_hour)
	VALUES (1001, 1, 'Jenny', 'Matrix', 51.00),
	(1002, 1, 'John', 'Matrix', 48.75),
	(1003, 1, 'Billy', 'Bennett', 31.15);

-- -- Timesheets
INSERT INTO public.timesheet(employee_id, date_worked, hours_worked, billable, description)
VALUES (2, '2020-02-28', 6, true, 'Worked on Plan'),
(2, '2020-03-01', 8, true, 'Built release pipe'),
(2, '2020-03-02', 7, true, 'Created engagement presentation'),
(2, '2020-03-03', 4, true, 'Setup equipment'),
(2, '2020-03-03', 3, false, 'Build up'),
(2, '2020-03-04', 5, true, 'Released Steam'),
(3, '2020-03-04', 2, true, 'Let off some Steam'),
(3, '2020-03-04', 3, false, 'Project postmortem');

-- 1004  (MANAGER USER), 1005, 1006, 1007
INSERT INTO public.users(username, password_hash) 
VALUES ('tjones', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
('mpalin', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
('gchapman', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
('ccleveland', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');

-- 2 (DEPARTMENT)
INSERT INTO public.department(manager_id, name)VALUES (1004, 'Funny Walks'); 

-- 4, 5, 6, 7
INSERT INTO public.employee( user_id, department_id, first_name, last_name, rate_per_hour)
	VALUES (1004, 2, 'Terry', 'Jones', 42.00),
	(1005, 2, 'Michael', 'Palin', 42.00),
	(1006, 2, 'Graham', 'Chapman', 42.00),
	(1007, 2, 'Carol', 'Cleveland', 42.00);
	
-- -- Timesheets
INSERT INTO public.timesheet(employee_id, date_worked, hours_worked, billable, description)
VALUES (4, '2020-02-28', 8, true, 'Worked on walk A'),
(4, '2020-03-01', 3, false, 'Thought about new walk'),
(5, '2020-03-02', 9, true, 'Improved the silliest walk'),
(5, '2020-03-03', 7, true, 'Finished silliest walk improvements'),
(6, '2020-03-03', 2, true, 'Worked on Walk B'),
(6, '2020-03-03', 1, false, 'Fell down'),
(6, '2020-03-03', 6, false, 'Continue work on Walk B'),
(7, '2020-03-04', 5, true, 'Meeting with Tim'),
(7, '2020-03-04', 12, true, 'Found a shubbery'),
(7, '2020-03-04', 2, true, 'Delivered shubbery'),
(6, '2020-03-04', 2, true, 'Delivered shubbery'),
(5, '2020-03-04', 2, true, 'Delivered shubbery'),
(4, '2020-03-04', 2, true, 'Delivered shubbery');

-- 1008  (MANAGER USER), 1009, 1010
INSERT INTO public.users(username, password_hash) 
VALUES ('jburton', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
('glaw', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
('elee', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');

-- 3 (DEPARTMENT)
INSERT INTO public.department(manager_id, name)VALUES (1008, 'Logistics'); 

-- 8, 9, 10
INSERT INTO public.employee( user_id, department_id, first_name, last_name, rate_per_hour)
	VALUES (1008, 3, 'Jack', 'Burton', 21.10),
	(1009, 3, 'Gracie', 'Law', 45.75),
	(1010, 3, 'Eddie', 'Lee', 25.00);

INSERT INTO public.timesheet(employee_id, date_worked, hours_worked, billable, description)
VALUES (8, '2020-02-28', 4, true, 'Gave coworker a ride'),
(8, '2020-02-28', 6, false, 'Called Truck Insurrance company'),
(9, '2020-02-28', 12, true, 'Reporting'),
(10, '2020-02-28', 10, true, 'Documented elements');

COMMIT;