-- CREATE DATABASE contacts;

<<<<<<< HEAD
=======
DROP TABLE IF EXISTS email;
>>>>>>> 08cbe9c233337fe9cd0796c2b07e915e65ead1b1
DROP TABLE IF EXISTS person_phone;
DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS phone;

CREATE TABLE person (
	person_id serial primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	date_modified timestamp default current_timestamp
);

CREATE TABLE address (
	address_id serial primary key,
	address_type varchar(12) not null,
	type_description varchar(100),
	line_one varchar(128) not null,
	line_two varchar(128),
	city varchar(32) not null,
	district varchar(32) not null,
	postal_code varchar(12) not null,
	country_code char(3) not null,
	
	constraint chk_address_type check ( address_type IN ('HOME', 'WORK', 'SHIPPING', 'BILLING', 'OTHER') ),
	constraint chk_address_type_description check ( 
		(address_type = 'OTHER' AND type_description IS NOT NULL ) 
		OR (address_type != 'OTHER' AND type_description IS NULL) )
);

CREATE TABLE person_address (
	person_id bigint not null,
	address_id bigint not null,
	
	constraint fk_person_address_person_id foreign key (person_id) references person(person_id),
	constraint fk_person_address_address_id foreign key (address_id) references address(address_id),
	constraint pk_person_address primary key (person_id, address_id)
);

CREATE TABLE phone (
	phone_id serial primary key,
	number_type varchar(20) not null,
	type_description varchar(100),
	phone_number varchar(22) not null,
	
	constraint chk_number_type check ( number_type IN ('HOME', 'WORK', 'MOBILE', 'OTHER') ),
	constraint chk_phone_type_description check ( (number_type = 'OTHER' AND type_description IS NOT NULL)
				OR (number_type != 'OTHER' AND type_description IS NULL) )
);

CREATE TABLE person_phone (
	person_id bigint not null,
	phone_id bigint not null,
<<<<<<< HEAD
);

=======
	
	constraint fk_person_phone_person_id foreign key (person_id) references person(person_id),
	constraint fk_person_phone_phone_id foreign key (phone_id) references phone(phone_id),
	constraint pk_person_phone primary key (person_id, phone_id)

);

CREATE TABLE email (
	email_id serial primary key,
	person_id bigint not null,
	email varchar(255) not null,
	email_type varchar(20) not null,
	type_description varchar(100),
	
	constraint fk_email_person_id foreign key (person_id) references person(person_id),
	constraint chk_email_type check ( email_type IN ('PERSONAL', 'WORK', 'STUDENT', 'OTHER')),
	constraint chk_email_type_description check ( (email_type = 'OTHER' AND type_description IS NOT NULL) 
				OR (email_type != 'OTHER' AND type_description IS NULL) )
);
>>>>>>> 08cbe9c233337fe9cd0796c2b07e915e65ead1b1

