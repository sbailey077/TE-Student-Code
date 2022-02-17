-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)
SELECT DISTINCT p.person_name
FROM movie AS m
JOIN person AS p ON p.person_id = m.director_id
JOIN collection AS c ON c.collection_id = m.collection_id
WHERE c.collection_name = 'Harry Potter Collection';
