-- Create DATABASE Meetups;

DROP TABLE IF EXISTS event_member;
DROP TABLE IF EXISTS member_phone;
DROP TABLE IF EXISTS member_email;
DROP TABLE IF EXISTS interest_group_member;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS interest_group;
DROP TABLE IF EXISTS phone;
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS member;

CREATE TABLE member (
	member_id serial primary key,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	date_of_birth date NOT NULL
);

CREATE TABLE email (
	email_id serial primary key,
	email_address varchar(255) NOT NULL,
	email_reminder_flag boolean NOT NULL
);

CREATE TABLE member_email (
	member_id bigint NOT NULL,
	email_id bigint NOT NULL,
	
	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member(member_id),
	CONSTRAINT fk_email_id FOREIGN KEY (email_id) REFERENCES email(email_id),
	CONSTRAINT pk_member_email PRIMARY KEY (member_id, email_id)
);

CREATE TABLE phone (
	phone_id serial primary key,
	phone_number varchar(16)
);

CREATE TABLE member_phone (
	member_id serial NOT NULL,
	phone_id serial NOT NULL,
	
	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member(member_id),
	CONSTRAINT fk_phone_id FOREIGN KEY (phone_id) REFERENCES phone(phone_id),
	CONSTRAINT pk_member_phone PRIMARY KEY (member_id, phone_id)
);

CREATE TABLE interest_group (
	interest_group_id serial primary key,
	interest_group_name varchar(255) UNIQUE NOT NULL,
	number_of_members int NOT NULL,
	
	CONSTRAINT chk_number_of_members CHECK (number_of_members >= 0)
);

CREATE TABLE interest_group_member (
	interest_group_id serial NOT NULL,
	member_id serial NOT NULL,
	
	CONSTRAINT fk_interest_group_id FOREIGN KEY (interest_group_id) REFERENCES interest_group (interest_group_id),
	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member (member_id),
	CONSTRAINT pk_interest_group_member PRIMARY KEY (interest_group_id, member_id)
);

CREATE TABLE event (
	event_id serial primary key,
	event_name varchar(128) NOT NULL,
	event_description varchar(255) NOT NULL,
	start_date_and_time timestamp NOT NULL,
	members_attending int NOT NULL,
	duration_in_minutes int NOT NULL,
	group_name varchar(255),
	
	CONSTRAINT chk_number_of_members CHECK (members_attending >= 0),
	CONSTRAINT chk_duration_in_minutes CHECK (duration_in_minutes >= 0),
	CONSTRAINT fk_group_name FOREIGN KEY (group_name) REFERENCES interest_group (interest_group_name)
);

CREATE TABLE event_member (
	event_id serial NOT NULL,
	member_id serial NOT NULL,
	
	CONSTRAINT fk_event_id FOREIGN KEY (event_id) REFERENCES event (event_id),
	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member (member_id)
);

INSERT INTO member (first_name, last_name, date_of_birth) 
VALUES ('Sam', 'Bailey', '07/01/1996');

INSERT INTO member (first_name, last_name, date_of_birth)
VALUES('Jordan', 'Reding', '09/24/1994');

INSERT INTO member (first_name, last_name, date_of_birth)
VALUES('Napoleon', 'Dynamite', '11/06/1988');

INSERT INTO member (first_name, last_name, date_of_birth)
VALUES('Kip', 'Dynamite', '04/02/1972');

INSERT INTO member (first_name, last_name, date_of_birth)
VALUES('Deb', 'Bradshaw', '02/06/1988');

INSERT INTO member (first_name, last_name, date_of_birth)
VALUES('Tim', 'The Enchanter', '07/12/1236');

INSERT INTO member (first_name, last_name, date_of_birth)
VALUES('Rico', 'Dynamite', '03/20/1968');

INSERT INTO member (first_name, last_name, date_of_birth)
VALUES ('Pedro', 'Sanchez', '12/02/1990');

INSERT INTO email (email_id, email_address, email_reminder_flag)
VALUES (1, 's.bailey077@gmail.com', true);

INSERT INTO email (email_id, email_address, email_reminder_flag)
VALUES (2, 'jreding@gmail.com', true);

INSERT INTO email (email_id, email_address, email_reminder_flag)
VALUES (3, 'ligertamer@gmail.com', false);

INSERT INTO email (email_id, email_address, email_reminder_flag)
VALUES (4, 'kip@rexkwondo.com', false);

INSERT INTO email (email_id, email_address, email_reminder_flag)
VALUES (5, 'deb@dsphoto.com', true);

INSERT INTO email (email_id, email_address, email_reminder_flag)
VALUES (6, 'africanswallow@gmail.com', true);

INSERT INTO email (email_id, email_address, email_reminder_flag)
VALUES (7, 'footballstar82@gmail.com', true);

INSERT INTO email (email_id, email_address, email_reminder_flag)
VALUES (8, 'psanchez@gmail.com', false);

INSERT INTO member_email(member_id, email_id)
VALUES (1, 1);

INSERT INTO member_email(member_id, email_id)
VALUES (2, 2);

INSERT INTO member_email(member_id, email_id)
VALUES (3, 3);

INSERT INTO member_email(member_id, email_id)
VALUES (4, 4);

INSERT INTO member_email(member_id, email_id)
VALUES (5, 5);

INSERT INTO member_email(member_id, email_id)
VALUES (6, 6);

INSERT INTO member_email(member_id, email_id)
VALUES (7, 7);

INSERT INTO member_email(member_id, email_id)
VALUES (8, 8);

INSERT INTO phone (phone_id, phone_number)
VALUES (1, '513-600-1184');

INSERT INTO phone (phone_id, phone_number)
VALUES (2, '716-946-4036');

INSERT INTO phone (phone_id, phone_number)
VALUES (3, '208-764-2345');

INSERT INTO phone (phone_id, phone_number)
VALUES (4, '208-994-2584');

INSERT INTO phone (phone_id, phone_number)
VALUES (5, '208-912-7543');

INSERT INTO phone (phone_id, phone_number)
VALUES (6, '208-235-7733');

INSERT INTO phone (phone_id, phone_number)
VALUES (7, '208-944-8721');

INSERT INTO phone (phone_id, phone_number)
VALUES (8, '208-676-1212');

INSERT INTO member_phone (member_id, phone_id)
VALUES(1, 1);

INSERT INTO member_phone (member_id, phone_id)
VALUES(2, 2);

INSERT INTO member_phone (member_id, phone_id)
VALUES(3, 3);

INSERT INTO member_phone (member_id, phone_id)
VALUES(4, 4);

INSERT INTO member_phone (member_id, phone_id)
VALUES(5, 5);

INSERT INTO member_phone (member_id, phone_id)
VALUES(6, 6);

INSERT INTO member_phone (member_id, phone_id)
VALUES(7, 7);

INSERT INTO member_phone (member_id, phone_id)
VALUES(8, 8);

INSERT INTO interest_group (interest_group_id, interest_group_name, number_of_members)
VALUES (1, 'Nessie Alliance Support Group', 3);

INSERT INTO interest_group (interest_group_id, interest_group_name, number_of_members)
VALUES (2, 'New River Alliance of Climbers', 3);

INSERT INTO interest_group (interest_group_id, interest_group_name, number_of_members)
VALUES (3, '24 and 32 Piece Set Enthusiasts', 2);

INSERT INTO interest_group_member (interest_group_id, member_id)
VALUES (1, 3);

INSERT INTO interest_group_member (interest_group_id, member_id)
VALUES (1, 8);

INSERT INTO interest_group_member (interest_group_id, member_id)
VALUES (1, 5);

INSERT INTO interest_group_member (interest_group_id, member_id)
VALUES (2, 1);

INSERT INTO interest_group_member (interest_group_id, member_id)
VALUES (2, 2);

INSERT INTO interest_group_member (interest_group_id, member_id)
VALUES (2, 6);

INSERT INTO interest_group_member (interest_group_id, member_id)
VALUES (3, 7);

INSERT INTO interest_group_member (interest_group_id, member_id)
VALUES (3, 4);

INSERT INTO event (event_id, event_name, event_description, start_date_and_time, members_attending, duration_in_minutes, group_name)
VALUES (1, 'Loch Ness Explosion Discussion', 'Discussion of the recent explosion in Lake Loch Ness due to Japanese explosives.', '2022-02-28 12:00:00', 2, 30, 'Nessie Alliance Support Group');

INSERT INTO event (event_id, event_name, event_description, start_date_and_time, members_attending, duration_in_minutes, group_name)
VALUES (2, 'Rebolt South Nuttall', 'Begin rebolting of the South Nuttall crag.', '03/25/2022 10:00:00', 3, 360, 'New River Alliance of Climbers');

INSERT INTO event (event_id, event_name, event_description, start_date_and_time, members_attending, duration_in_minutes, group_name)
VALUES (3, 'Carnifex Ferry Trail', 'Start making a trail for the horribly neglected Carnifex Ferry Crag.', '03/26/2022 09:00:00', 3, 360, 'New River Alliance of Climbers');

INSERT INTO event (event_id, event_name, event_description, start_date_and_time, members_attending, duration_in_minutes, group_name)
VALUES (4, '24 Piece Set Sale Day', 'Go door to door to sell 24 piece sets.', '03/28/2022 08:00:00', 2, 360, '24 and 32 Piece Set Enthusiasts');

INSERT INTO event_member (event_id, member_id)
VALUES (1, 3);

INSERT INTO event_member (event_id, member_id)
VALUES (1, 8);

INSERT INTO event_member (event_id, member_id)
VALUES (2, 1);

INSERT INTO event_member (event_id, member_id)
VALUES (2, 2);

INSERT INTO event_member (event_id, member_id)
VALUES (2, 6);

INSERT INTO event_member (event_id, member_id)
VALUES (3, 1);

INSERT INTO event_member (event_id, member_id)
VALUES (3, 2);

INSERT INTO event_member (event_id, member_id)
VALUES (3, 6);

INSERT INTO event_member (event_id, member_id)
VALUES (4, 4);

INSERT INTO event_member (event_id, member_id)
VALUES (4, 7);

