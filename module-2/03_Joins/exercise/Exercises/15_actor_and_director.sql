-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT m.title, p.person_name
FROM movie AS m
JOIN person AS p ON p.person_id = m.director_id
JOIN movie_actor AS ma ON ma.movie_id = m.movie_id
WHERE m.director_id = ma.actor_id;
