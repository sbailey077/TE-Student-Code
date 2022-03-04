-- CREATE DATABASE JavaBlueMart;

--DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS item_types;

CREATE TABLE item (
	item_id serial primary key,
	type_code varchar(10) not null,
	sku varchar(10) unique not null,
	name varchar(255) not null,
	description text,
	price numeric not null,
	is_perishable boolean DEFAULT false
);

CREATE TABLE item_types (
	code varchar(10) primary key,
	name varchar(255) unique not null
);

-- CREATE TABLE pet (
-- 	pet_id serial primary key,
-- 	item_id bigint not null,
-- 	weight int default 0,
-- 	pet_name varchar(255)
-- );


-- INSERT Item Types
-- INSERT INTO item_types VALUES ('F', 'Food'), ('C', 'Clothing'), ('P', 'Pet'), ('B', 'Book');
INSERT INTO item_types VALUES ('F', 'Food'), ('C', 'Clothing'), ('B', 'Book');

-- INSERT non-Pet ITEMS
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'F', '001', 'Cake', 'A chocolate cake', 10, true);
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'F', '12', 'Chips', 'A bag of chips', 1.25, true);	
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'F', '18', 'Candy', 'Some sort of sweet stuff', 0.55, true);		
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'C', '002', 'Flip Flop Sandals', 'Protect your feet, but only the bottoms', 7.00, false);	
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'C', 'RR01', 'Java Blue Snuggie', 'Keeps you both ridiculously warm and looking', 22.00, false);	
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'B', 'B12', 'Head First Java', 'Explains the insanity of Java', 18.75, false);		
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'B', '78', 'Horrors of JavaScript', 'Learn the dark arts of JavaScript', 8.95, false);	
	
-- INSERT PETs
-- INSERT INTO public.item(
-- 	item_id, type_code, sku, name, description, price, is_perishable)
-- 	VALUES (DEFAULT, 'P', 'cat01', 'Cat', 'Covered in fur and attitude', 10, true);	
-- INSERT INTO public.pet(
-- 	pet_id, item_id, weight, pet_name)
-- 	VALUES (DEFAULT, CURRVAL('item_item_id_seq'), 10, 'Evil Bob');

-- INSERT INTO public.item(
-- 	item_id, type_code, sku, name, description, price, is_perishable)
-- 	VALUES (DEFAULT, 'P', 'f22', 'Frog', 'Greenish and not a toad', 5.25, true);	
-- INSERT INTO public.pet(
-- 	pet_id, item_id, weight, pet_name)
-- 	VALUES (DEFAULT, CURRVAL('item_item_id_seq'), 25, 'Hoppy');

-- CREATE Constraints
ALTER TABLE item ADD CONSTRAINT fk_item_item_type FOREIGN KEY (type_code) REFERENCES item_types(code);
--ALTER TABLE pet ADD CONSTRAINT fk_pet_item_id FOREIGN KEY (item_id) REFERENCES item(item_id);