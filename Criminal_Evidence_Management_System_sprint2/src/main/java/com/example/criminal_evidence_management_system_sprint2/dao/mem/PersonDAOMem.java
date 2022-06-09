package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.Person;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IPersonDAO;

import java.util.List;

public class PersonDAOMem implements ICrudBase<Person, Integer>, IPersonDAO {
    private List<Person> lst;

    public PersonDAOMem(List<Person> lst) {
        this.lst = lst;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Person getById(Integer integer) {
        return null;
    }

    @Override
    public Person insert(Person person) {
        return null;
    }

    @Override
    public Person update(Person person, Integer integer) {
        return null;
    }
}
