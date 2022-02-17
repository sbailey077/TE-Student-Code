-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region FROM state
ORDER BY census_region DESC, state_name;

-- The biggest park by area
SELECT * FROM park
ORDER BY area DESC;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, round(((current_date - date_established)/365.25),0) AS age_yers_old FROM park
ORDER BY date_established, park_name
LIMIT 20;
--determine the age of park?

--order them by their age, then by name


-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ', ' || state_abbreviation) AS city_and_state FROM city;

-- The all parks by name and date established.
SELECT ('Name: ' || park_name || ', Est: ' || date_established) AS park_date_established FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
--SELECT state_name, census_region FROM state
SELECT (census_region || ': ' || state_name) AS region_and_state FROM state
WHERE census_region ('West','Midwest')
ORDER BY region_and_state;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT round(AVG(population), 1) AS avg_population FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_population_of_south_west FROM state
WHERE census_region IN ('West','South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(*) AS num_of_city_over_million FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(*) AS count_of_nicknames FROM state
WHERE state_nickname IS NOT NULL;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest_park, MAX(area) AS largest_park FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name) AS city_count, state_abbreviation FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, round(AVG(area), 0) AS avg_park_size FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS total_pop_of_state_cities FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS min_pop_city FROM city
GROUP BY state_abbreviation
ORDER BY min_pop_city;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
FROM city
ORDER BY city_name
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT state_name FROM state
WHERE state_abbreviation = 'CA';

SELECT COUNT(city_name) AS cities, state_abbreviation FROM city
GROUP BY state_abbreviation;

SELECT COUNT(city_name) AS cities, (SELECT state_name FROM state
WHERE state_abbreviation = city.state_abbreviation) FROM city
GROUP BY state_abbreviation;

-- Include the names of the smallest and largest parks
SELECT MIN(area) AS smallest_park, MAX(area) AS largest_park FROM park;

SELECT park_name, area from park
WHERE area = 33682.6;

SELECT park_name, area FROM park, (SELECT MIN(area) AS smallest_park, MAX(area) AS largest_park FROM park) AS qualified_data
WHERE park.area = qualified_data.smallest_park OR park.area = qualified_data.largest_park;
-- List the capital cities for the states in the Northeast census region.

SELECT * FROM state
WHERE census_region = 'Northeast';

SELECT city_name, state_abbreviation FROM city
WHERE city_id IN (
	SELECT capital FROM state
	WHERE census_region = 'Northeast'
);
