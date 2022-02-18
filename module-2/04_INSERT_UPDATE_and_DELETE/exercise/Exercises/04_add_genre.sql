-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)
SELECT * FROM genre;
SELECT * FROM genre WHERE genre_name = 'Sports';
SELECT * FROM movie_genre WHERE movie_id = (SELECT movie_id FROM movie WHERE title = 'Coach Carter');


INSERT INTO genre (genre_name) VALUES ('Sports');
INSERT INTO movie_genre (genre_id, movie_id) VALUES (11771, 7214);

