package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<Person>();
    @Override
    public Person insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName() ));
        return  DB.stream().filter(user->user.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Person> selectPeople() {

        return DB;
    }

    @Override
    public boolean DeletePersonById(UUID id) {
        Optional<Person> maybe=selectPerson(id);
        maybe.ifPresent(person->this.delete(person));
        if(maybe.isEmpty())return false;
        return true;
    }

    @Override
    public Person updatePersonById(UUID id, Person person) {

        selectPerson(id).map(individual->{
           int index =DB.indexOf(individual);
           if(index>=0) {
               DB.set(index ,new Person(individual.getId(),person.getName()));

           }
           return null;

       });
        return selectPerson(id).orElse(null);


    }

    @Override
    public Optional<Person> selectPerson(UUID id) {
        return DB.stream().filter(person->person.getId().equals(id)).findFirst();
    }
    public int delete(Person person){
        Person foundPerson=DB.stream().filter(user->user.getId().equals(person.getId())).findFirst().get();
        int index=DB.indexOf(foundPerson);
        DB.remove(index);
        return 1;


    }
}
