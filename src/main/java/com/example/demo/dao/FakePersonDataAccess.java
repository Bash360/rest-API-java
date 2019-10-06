package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakeDao")
public class FakePersonDataAccess implements PersonDao{
    private static ArrayList<Person> DB = new ArrayList();
    @Override
    public int insertPerson(UUID id, Person person) {
      DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPerson(UUID id) {
        return DB.stream().filter(person->person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
       Optional<Person> personMaybe= selectPerson(id);
       if(personMaybe.isEmpty()) return 0;
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPerson(id).map(foundPerson->{
            int indexOfPerson= DB.indexOf(foundPerson);
            if(indexOfPerson>=0){
                DB.set(indexOfPerson,new Person(id,update.getName()));
                return 1;
            }
            return 0;

        }).orElse(0);
    }
}
