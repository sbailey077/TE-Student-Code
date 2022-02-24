BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet;
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

CREATE TABLE pet (
	pet_id serial primary key,
	item_id bigint not null,
	weight int default 0,
	pet_name varchar(255)
);


-- INSERT Item Types
INSERT INTO item_types VALUES ('F', 'Food'), ('C', 'Clothing'), ('P', 'Pet'), ('B', 'Book');

-- INSERT non-Pet ITEMS
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'F', '100', 'FoodOne', 'FoodOneDescription', 10, true);
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'F', '200', 'FoodTwo', 'FoodTwoDescription', 20, true);
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'C', 'C01', 'ClothingOne', 'Clothing One Description', 7.00, false);
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'C', 'C02', 'ClothingTwo', 'Clothing Two Description', 22.00, false);
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'B', 'Book01', 'BookOne', 'Book One Description', 18.75, false);
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'B', 'Book02', 'BookTwo', 'Book Two Description', 8.95, false);

-- INSERT PETs
INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'P', 'P1', 'PetOne', 'PetOne Description', 10, true);
INSERT INTO public.pet(
	pet_id, item_id, weight, pet_name)
	VALUES (DEFAULT, CURRVAL('item_item_id_seq'), 10, 'PetOne Name');

INSERT INTO public.item(
	item_id, type_code, sku, name, description, price, is_perishable)
	VALUES (DEFAULT, 'P', 'P2', 'PetTwo', 'PetTwo Description', 5.25, true);
INSERT INTO public.pet(
	pet_id, item_id, weight, pet_name)
	VALUES (DEFAULT, CURRVAL('item_item_id_seq'), 25, 'PetTwo Name');

-- CREATE Constraints
ALTER TABLE item ADD CONSTRAINT fk_item_item_type FOREIGN KEY (type_code) REFERENCES item_types(code);
ALTER TABLE pet ADD CONSTRAINT fk_pet_item_id FOREIGN KEY (item_id) REFERENCES item(item_id);

COMMIT;