--CREATE Database NewRiverDB

DROP TABLE IF EXISTS route;
DROP TABLE IF EXISTS crag;
DROP TABLE IF EXISTS area;

CREATE TABLE area (
	area_id serial primary key,
	area_name varchar(32) NOT NULL UNIQUE,
	drive_time_from_aac_in_minutes int NOT NULL,
	access_issues varchar(264)
);

CREATE TABLE crag (
	crag_id serial primary key,
	crag_name varchar(32) NOT NULL UNIQUE,
	area_id bigint NOT NULL,
	area_name varchar(32) NOT NULL,
	hike_time_in_minutes int NOT NULL,
	route_count int NOT NULL,
	kid_friendly boolean,
	dog_friendly boolean,
	CONSTRAINT fk_area_id FOREIGN KEY (area_id) REFERENCES area(area_id),
	CONSTRAINT fk_area_name FOREIGN KEY (area_name) REFERENCES area(area_name)
);

CREATE TABLE route (
	route_number int primary key,
	route_name varchar(64) NOT NULL UNIQUE,
	crag_id bigint NOT NULL, 
	crag_name varchar(32) NOT NULL, 
	area_id bigint NOT NULL,
	area_name varchar(32) NOT NULL,
	height_in_feet int NOT NULL,
	grade varchar(8) NOT NULL,
	steepness varchar(32) NOT NULL,
	dryness_level varchar(32),
	route_type varchar(32) NOT NULL,
	bolt_count int,
	has_anchors boolean NOT NULL,
	book_rating varchar(4) NOT NULL,
	personal_rating varchar(4),
	comments varchar(264),
	CONSTRAINT area_id FOREIGN KEY (area_id) REFERENCES area(area_id),
	CONSTRAINT area_name FOREIGN KEY (area_name) REFERENCES area(area_name),
	CONSTRAINT fk_crag_id FOREIGN KEY (crag_id) REFERENCES crag(crag_id),
	CONSTRAINT fk_crag_name FOREIGN KEY (crag_name) REFERENCES crag(crag_name)
);

INSERT INTO area (area_name, drive_time_from_aac_in_minutes)
VALUES ('Endless Wall', 5);

INSERT INTO crag(crag_name, area_id, area_name, hike_time_in_minutes, route_count, kid_friendly, dog_friendly)
VALUES ('Fern Point Boulders', 1, 'Endless Wall', 15, 7, false, false);

INSERT INTO route(route_number, route_name, crag_id, crag_name, area_id, area_name, height_in_feet, grade, steepness, dryness_level, route_type, bolt_count, has_anchors, book_rating)
VALUES (1, 'Standing Up in the Big Tent', 1, 'Fern Point Boulders', 1, 'Endless Wall', 40, '5.12c', 'Vertical', 'Does not stay dry', 'Sport', 4, false, '**');
			  







