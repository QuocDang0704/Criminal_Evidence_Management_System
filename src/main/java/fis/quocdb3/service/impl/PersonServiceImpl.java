package fis.quocdb3.service.impl;

import fis.quocdb3.domain.Person;
import fis.quocdb3.repository.PersonRepository;
import fis.quocdb3.service.CrudBase;
import fis.quocdb3.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonServiceImpl
        implements IPersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person add(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return this.personRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Person getById(Long id) {
        return this.personRepository.findById(id)
                .orElseThrow(() -> {throw new IllegalArgumentException(String.format("Not found with id: %s", id));});
    }

    @Override
    public void delete(Long id) {
        Person person = new Person();
        person.setId(id);
        this.personRepository.delete(person);
    }
}
