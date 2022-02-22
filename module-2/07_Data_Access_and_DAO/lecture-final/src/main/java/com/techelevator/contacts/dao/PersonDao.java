package com.techelevator.contacts.dao;

import com.techelevator.contacts.model.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getAll();
    Person getById(long personId);
    Person add(Person person);
    void update(Person person);
    void delete(long personId);
}
