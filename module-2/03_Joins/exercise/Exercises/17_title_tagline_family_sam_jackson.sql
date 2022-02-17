-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)
SELECT m.title, m.tagline
FROM movie AS m
JOIN movie_actor AS ma ON ma.movie_id = m.movie_id
JOIN person AS p ON p.person_id = ma.actor_id
JOIN movie_genre AS mg ON mg.movie_id = m.movie_id
JOIN genre AS g ON g.genre_id = mg.genre_id
WHERE g.genre_name = 'Family' AND p.person_name = 'Samuel L. Jackson';
