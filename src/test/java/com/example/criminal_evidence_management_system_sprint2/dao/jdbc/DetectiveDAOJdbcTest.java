package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.common.EmploymentStatus;
import com.example.criminal_evidence_management_system_sprint2.common.Rank;
import com.example.criminal_evidence_management_system_sprint2.core.Detective;
import com.example.criminal_evidence_management_system_sprint2.core.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DetectiveDAOJdbcTest {
    private Long size = null;

    @BeforeEach
    void initDataEachTest(){
        DetectiveDAOJdbc detective = new DetectiveDAOJdbc();
        size = Long.valueOf(detective.getAll().size());
    }

    @Test
    void getAll() {
        DetectiveDAOJdbc detective = new DetectiveDAOJdbc();
        detective.getAll().forEach(i -> System.out.println(i.toString()));
        assertEquals(size, detective.getAll().size());
    }

    @Test
    void getById() {
        DetectiveDAOJdbc detective = new DetectiveDAOJdbc();
        System.out.println(detective.getById(4L));
    }

    @Test
    void insert() {
        DetectiveDAOJdbc detective = new DetectiveDAOJdbc();
        Detective dec = new Detective();
        Person person = new Person();
        person.setCreateAt(LocalDateTime.now());
        person.setModifiedAt(LocalDateTime.now());
        person.setVersion(1);
        person.setFirstName("Quốc");
        person.setHiringDate(LocalDateTime.now());
        person.setLastName("Đặng");
        person.setPassword("1234567");
        person.setUsername("quoc");
        dec.setVersion(1);
        dec.setArmed(true);
        dec.setBadgeNumber("0234212");
        dec.setRank(Rank.valueOf("JUNIOR"));
        dec.setStatus(EmploymentStatus.valueOf("ACTIVE"));
        dec.setPerson(person);
        detective.insert(dec);
        System.out.println(dec.toString());
        assertEquals(size+1, detective.getAll().size());
    }

    @Test
    void update() {
        DetectiveDAOJdbc detective = new DetectiveDAOJdbc();
        Detective dec = new Detective();
        Person person = new Person();
        person.setCreateAt(LocalDateTime.now());
        person.setModifiedAt(LocalDateTime.now());
        person.setVersion(2);
        person.setFirstName("Quốcccc");
        person.setHiringDate(LocalDateTime.now());
        person.setLastName("Đặng");
        person.setPassword("123456732");
        person.setUsername("quocUpdate");
        dec.setVersion(1);
        dec.setArmed(true);
        dec.setBadgeNumber("");
        dec.setRank(Rank.valueOf("JUNIOR"));
        dec.setStatus(EmploymentStatus.valueOf("ACTIVE"));
        dec.setPerson(person);
        detective.update(dec, 8L);
        System.out.println(dec.toString());
        assertEquals(size, detective.getAll().size());
    }

    @Test
    void delete() {
        DetectiveDAOJdbc detective = new DetectiveDAOJdbc();
        System.out.println(size);
        detective.delete(4L);
        assertEquals(size-1, detective.getAll().size());
    }
}