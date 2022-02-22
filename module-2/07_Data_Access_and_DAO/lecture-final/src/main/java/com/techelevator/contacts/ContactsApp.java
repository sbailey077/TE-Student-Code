package com.techelevator.contacts;

import com.techelevator.contacts.dao.JdbcPersonDao;
import com.techelevator.contacts.dao.PersonDao;
import com.techelevator.contacts.model.Person;
import org.apache.commons.dbcp2.BasicDataSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {

    /*
        This is not part of the DAO Pattern, but is an example of using a DAO
     */
    public static void main(String[] args) {

        /*
            1. Create a DataSource
         */
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/contacts");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        /*
            2. Instantiate the DAO and passing the datasource in the constructor
         */
        PersonDao personDao = new JdbcPersonDao(dataSource);

        List<Person> persons = personDao.getAll();

        for (Person person: persons) {
            printPerson(person);
        }

        Scanner userInput = new Scanner(System.in);
        System.out.println();
        System.out.print("Select user by id >>>");
        int selectedId = userInput.nextInt();
        userInput.nextLine();

        Person selectedPerson = personDao.getById(selectedId);
        printPerson(selectedPerson);

        System.out.println();
        System.out.println("First Name: ");
        String firstName = userInput.nextLine();
        System.out.println("Last Name: ");
        String lastName = userInput.nextLine();

        Person newPerson = new Person();
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setDateModified(LocalDate.now());

        personDao.add(newPerson);

        printPerson(newPerson);

        newPerson.setFirstName("Someone");
        newPerson.setLastName("Else");
        personDao.update(newPerson);

        personDao.delete(newPerson.getPersonId());
    }

    private static void printPerson(Person person) {
        System.out.print( person.getPersonId() );
        System.out.print(" " + person.getFirstName());
        System.out.println(" " + person.getLastName());
    }
}
