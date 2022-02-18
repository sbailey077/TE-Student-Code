-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT *
FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city.city_name, state.state_name
FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE city_name = 'Columbus';


-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation 
FROM park
JOIN park_state ON park.park_id = park_state.park_id
ORDER BY park_name;

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park.park_name, state.state_name
FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON park_state.state_abbreviation = state.state_abbreviation;


-- Modify the previous query to include the name of the state's capital city.
SELECT park.park_name, state.state_name, city.city_name
FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON park_state.state_abbreviation = state.state_abbreviation
JOIN city ON state.capital = city.city_id;

-- Modify the previous query to include the area of each park.
SELECT park.park_name, state.state_name, city.city_name AS capital_city, park.area, state.population AS state_population, city.population as city_population
FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON park_state.state_abbreviation = state.state_abbreviation
JOIN city ON state.capital = city.city_id;

-- Modify the previous query to only get parks in California ordered by park area from largest to smallest and show the top 2
SELECT park.park_name, state.state_name, city.city_name AS capital_city, park.area, state.population AS state_population, city.population as city_population
FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON park_state.state_abbreviation = state.state_abbreviation
JOIN city ON state.capital = city.city_id
WHERE state.state_abbreviation = 'CA'
ORDER BY park.area DESC
LIMIT 2;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city.city_name, city.population FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE state.census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT state.state_name, COUNT(city_name) AS number_of_cities
FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE state.census_region = 'Midwest'
GROUP BY state.state_abbreviation;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT state.state_name, COUNT(city_name) AS number_of_cities
FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE state.census_region = 'Midwest'
GROUP BY state.state_abbreviation
ORDER BY number_of_cities DESC;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
-- state_name (state), first date_established (park)
SELECT state.state_name, MIN(date_established)
FROM state
JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
JOIN park ON park_state.park_id = park.park_id
GROUP BY state.state_abbreviation;




-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state.state_name, MIN(date_established) AS earliest_park
FROM state
LEFT JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
LEFT JOIN park ON park_state.park_id = park.park_id
GROUP BY state.state_abbreviation
ORDER BY earliest_park;


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT city_name AS place_name
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name AS place_name
FROM state
WHERE state_name LIKE 'W%';

-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name AS place_name, 'City' AS kind_of_place
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name AS place_name, 'State' AS kind_of_place
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;


-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in DbVisualizer and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name
FROM genre;

-- The titles of all the Comedy movies
SELECT movie.title
FROM movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE genre.genre_name = 'Comedy';


-- Display the Top 5 genres and the number of movies in each of those genres
SELECT COUNT(*) AS number_of_movies, genre.genre_name
FROM movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
GROUP BY genre.genre_id, genre.genre_name
ORDER BY number_of_movies DESC
LIMIT 5;

-- How many times have each actor appeared together, ordered by the most to least appearances
SELECT COUNT(*) AS number_of_films, p1.person_name, p2.person_name
FROM movie
JOIN movie_actor ma1 ON movie.movie_id = ma1.movie_id
JOIN movie_actor ma2 ON movie.movie_id = ma2.movie_id AND ma1.actor_id != ma2.actor_id
JOIN person p1 ON ma1.actor_id = p1.person_id
JOIN person p2 ON ma2.actor_id = p2.person_id
GROUP BY p1.person_id, p2.person_id, p1.person_name, p2.person_name
ORDER BY number_of_films DESC;

