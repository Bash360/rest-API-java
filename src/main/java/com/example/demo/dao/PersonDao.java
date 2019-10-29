package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    public Person insertPerson(UUID id, Person person);
    default Person insertPerson(Person person ){
       UUID id= UUID.randomUUID();
       return insertPerson(id,person);

    }
    public List<Person> selectPeople();

    boolean DeletePersonById(UUID id);

    Person updatePersonById(UUID id,Person person);
    Optional<Person> selectPerson(UUID id);
}
