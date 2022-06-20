package com.FIS.Quocdb.dao.mem;

import com.FIS.Quocdb.dao.DAO;
import com.FIS.Quocdb.entities.Person;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class PersonDAO implements DAO<Person> {
    private final List<Person> personList = new ArrayList<>();

    public PersonDAO() {
        Date now = Calendar.getInstance().getTime();
        Instant instant = now.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    @Override
    public List<Person> getAll() {
        return personList;
    }

    @Override
    public Optional<Person> get(Long id) {
        return personList.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public void save(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {
        get(person.getId()).ifPresent(existPerson -> {
            existPerson.setFirstName(person.getFirstName());
            existPerson.setLastName(person.getLastName());
            existPerson.setPassword(person.getPassword());
        });
    }

    @Override
    public void delete(Person person) {
        get(person.getId()).ifPresent(personList::remove);
    }

    @Override
    public void deleteId(Long id) {

    }

}
