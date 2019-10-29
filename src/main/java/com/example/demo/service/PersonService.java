package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    @Autowired
    private final PersonDao personDao;

    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person addPerson(Person person){
        return  personDao.insertPerson(person);

    }
    public List<Person> getAllPeople(){
        return personDao.selectPeople();
    }
    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPerson(id);
    }
    public boolean deletePerson(UUID id){
        return personDao.DeletePersonById(id);
    }
    public Person updatePerson(UUID id,Person person){
        return personDao.updatePersonById(id,person);
    }
}
