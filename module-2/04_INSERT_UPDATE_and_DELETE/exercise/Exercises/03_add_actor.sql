-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)
SELECT * FROM movie WHERE title = 'Back to the Future';
SELECT * FROM person WHERE person_name = 'Eric Stoltz';
SELECT * FROM movie_actor WHERE movie_id = 105;

INSERT INTO movie_actor (movie_id, actor_id) VALUES (105, 7036);


