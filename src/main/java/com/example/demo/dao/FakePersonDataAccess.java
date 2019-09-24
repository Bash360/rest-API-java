package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.ArrayList;
import java.util.UUID;

public class FakePersonDataAccess implements PersonDao{
    private static ArrayList<Person> person = new ArrayList();
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }
}
