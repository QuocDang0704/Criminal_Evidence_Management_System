package com.example.criminal_evidence_management_system_sprint1.dao.mem;

import com.example.criminal_evidence_management_system_sprint1.core.Person;
import com.example.criminal_evidence_management_system_sprint1.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint1.dao.IPersonDAO;

import java.util.List;

public class PersonDAOMem implements ICrudBase<Person, Integer>, IPersonDAO {
    private List<Person> lst;

    public PersonDAOMem(List<Person> lst) {
        this.lst = lst;
    }

    @Override
    public List<Person> getAll() {
        return lst;
    }

    @Override
    public Person getById(Integer integer) {
        return lst.stream()
                .filter(i -> i.getPersonId().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Person insert(Person person) {
        if (this.getById(person.getPersonId())==null){
            lst.add(person);
            return person;
        }
        return null;
    }

    @Override
    public Person update(Person person, Integer integer) {
        if (this.getById(person.getPersonId())!=null){
            lst.forEach(i -> {
                if (i.getPersonId().equals(integer)){
                    person.setPersonId(integer);
                    i = person;
                    return;
                }
            });
        }
        return person;
    }

    @Override
    public void delete(Integer integer) {
        lst.removeIf(i -> i.getPersonId().equals(integer));
    }
}
