package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.core.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StorageDAOJdbcTest {
    private Long size = null;

    @BeforeEach
    void initDataEachTest(){
        StorageDAOJdbc jdbc = new StorageDAOJdbc();
        size = Long.valueOf(jdbc.getAll().size());
    }

    @Test
    void getAll() {
        StorageDAOJdbc jdbc = new StorageDAOJdbc();
        jdbc.getAll().forEach(i -> System.out.println(i.toString()));
        assertEquals(size,Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void getById() {
        StorageDAOJdbc jdbc = new StorageDAOJdbc();
        System.out.println(jdbc.getById(1L));
    }

    @Test
    void insert() {
        StorageDAOJdbc jdbc = new StorageDAOJdbc();
        Storage storage = new Storage();
        storage.setCreateAt(LocalDateTime.now());
        storage.setVersion(1);
        storage.setModifiedAt(LocalDateTime.now());
        storage.setName("TestInsert");
        storage.setLocation("location1");
        jdbc.insert(storage);
        assertEquals(size+1L, Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void update() {
        StorageDAOJdbc jdbc = new StorageDAOJdbc();
        Storage storage = new Storage();
        storage.setCreateAt(LocalDateTime.now());
        storage.setVersion(1);
        storage.setModifiedAt(LocalDateTime.now());
        storage.setName("TestInsert");
        storage.setLocation("location1");
        jdbc.update(storage, 1L);
        assertEquals(size, Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void delete() {
        StorageDAOJdbc jdbc = new StorageDAOJdbc();
        jdbc.delete(1L);
        assertEquals(size-1, Long.valueOf(jdbc.getAll().size()));
    }
}