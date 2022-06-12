package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.Person;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IPersonDAO;

import java.util.List;

public class PersonDAOMem implements ICrudBase<Person, Long>, IPersonDAO {
    private List<Person> lst;

    public PersonDAOMem(List<Person> lst) {
        this.lst = lst;
    }

    @Override
    public List<Person> getAll() {
        return lst;
    }

    @Override
    public Person getById(Long along) {
        return lst.stream()
                .filter(i -> i.getId().equals(along))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Person insert(Person person) {
        if (this.getById(person.getId())==null){
            lst.add(person);
            return person;
        }
        return null;
    }

    @Override
    public Person update(Person person, Long along) {
        if (this.getById(person.getId())!=null){
            lst.forEach(i -> {
                if (i.getId().equals(along)){
                    person.setId(along);
                    i = person;
                    return;
                }
            });
        }
        return person;
    }

    @Override
    public void delete(Long along) {
        lst.removeIf(i -> i.getId().equals(along));
    }
}
