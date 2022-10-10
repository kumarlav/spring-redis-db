package com.lk.service.impl;

import com.lk.model.Person;
import com.lk.service.PersonService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * The type Person service.
 *
 * @author LavKumar
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final String KEY ="PERSON";

    @Resource(name = "redisTemplate")
    private HashOperations<String, Integer, Person> opr;

    @Override
    public void addPerson(Person p) {
        opr.putIfAbsent(KEY, p.getId(), p);
    }

    @Override
    public void modifyPerson(Person p) {
        opr.put(KEY, p.getId(), p);
    }

    @Override
    public Person getPerson(Integer id) {
        return opr.get(KEY, id);
    }

    @Override
    public Map<Integer, Person> getAllPersons() {
        return opr.entries(KEY);
    }

    @Override
    public void removePerson(Integer id) {
        opr.delete(KEY, id);
    }
}
