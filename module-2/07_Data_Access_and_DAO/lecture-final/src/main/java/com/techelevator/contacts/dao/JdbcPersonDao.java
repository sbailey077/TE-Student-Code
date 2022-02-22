package com.techelevator.contacts.dao;

import com.techelevator.contacts.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<Person>();
        String sql = "SELECT person_id, first_name, last_name, date_modified FROM person";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while(rows.next()) {
            Person person = mapRowToPerson(rows);
            personList.add(person);
        }

        return personList;
    }

    @Override
    public Person getById(long personId) {
        Person person = null;

        String sql = "SELECT person_id, first_name, last_name, date_modified FROM person WHERE person_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId);

        if (rows.next()) {
            person = mapRowToPerson(rows);
        }

        return person;
    }

    @Override
    public Person add(Person person) {
        String sql = "INSERT INTO person (first_name, last_name, date_modified) VALUES (?, ?, ?) RETURNING person_id";
        Long id = jdbcTemplate.queryForObject(sql, Long.class, person.getFirstName(),
                person.getLastName(), person.getDateModified());
        person.setPersonId(id);
        return person;
    }

    @Override
    public void update(Person person) {
        String sql = "UPDATE person " +
                    "SET first_name = ?, last_name = ? " +
                    "WHERE person_id = ?";
        jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(), person.getPersonId());
    }

    @Override
    public void delete(long personId) {
        String sql = "DELETE FROM person WHERE person_id = ?";
        jdbcTemplate.update(sql, personId);
    }

    private Person mapRowToPerson(SqlRowSet rows) {
        Person person = new Person();
        person.setPersonId( rows.getLong("person_id") );
        person.setFirstName( rows.getString("first_name") );
        person.setLastName( rows.getString( "last_name" ) );
        if ( rows.getDate("date_modified") != null ) {
            person.setDateModified(rows.getDate("date_modified").toLocalDate());
        }
        return person;
    }
}
