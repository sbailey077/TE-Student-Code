-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
 SELECT DISTINCT p.person_name, p.birthday
 FROM person AS p
 JOIN movie_actor AS ma ON ma.actor_id = p.person_id
 JOIN movie AS m ON m.movie_id = ma.movie_id
 WHERE (p.birthday BETWEEN '01/01/1950' AND '12/31/1959') AND (m.release_date BETWEEN '01/01/1985' AND '12/31/1985');
