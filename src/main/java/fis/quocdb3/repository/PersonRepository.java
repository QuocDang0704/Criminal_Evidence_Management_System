package fis.quocdb3.repository;

import fis.quocdb3.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
    Boolean existsByUsername(String username);
}
