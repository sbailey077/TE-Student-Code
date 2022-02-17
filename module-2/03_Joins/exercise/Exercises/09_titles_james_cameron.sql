-- 9. The titles of movies directed by James Cameron (6 rows)
SELECT m.title 
FROM person AS p
JOIN movie AS m ON p.person_id = m.director_id
WHERE person_name = 'James Cameron';

