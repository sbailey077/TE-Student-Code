-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection" (28 rows)
SELECT DISTINCT p.person_name
FROM movie AS m
JOIN movie_actor AS ma ON ma.movie_id = m.movie_id
JOIN person AS p ON p.person_id = ma.actor_id
JOIN collection AS c ON c.collection_id = m.collection_id
WHERE c.collection_name = 'Back to the Future Collection';
