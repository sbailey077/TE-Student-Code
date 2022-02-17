-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).
SELECT g.genre_name, COUNT(g.genre_id) AS num_of_movies
FROM movie_genre AS mg
JOIN movie AS m on m.movie_id = mg.movie_id
JOIN genre AS g ON mg.genre_id = g.genre_id
GROUP BY g.genre_name;
