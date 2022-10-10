package com.lk.service;

import com.lk.model.Person;

import java.util.Map;

public interface PersonService {

    public void addPerson(Person p);
    public void modifyPerson(Person p);
    public Person getPerson(Integer id);
    public Map<Integer,Person> getAllPersons();
    public void removePerson(Integer id);
}
