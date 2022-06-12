package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.core.CriminalCase;
import com.example.criminal_evidence_management_system_sprint2.core.Evidence;
import com.example.criminal_evidence_management_system_sprint2.core.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvidenceDAOJdbcTest {
    private Long size = null;

    @BeforeEach
    void initDataEachTest(){
        EvidenceDAOJdbc jdbc = new EvidenceDAOJdbc();
        size = Long.valueOf(jdbc.getAll().size());
    }

    @Test
    void getAll() {
        EvidenceDAOJdbc jdbc = new EvidenceDAOJdbc();
        jdbc.getAll().forEach(i -> System.out.println(i.toString()));
        assertEquals(size, size = Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void getById() {
        EvidenceDAOJdbc jdbc = new EvidenceDAOJdbc();
        System.out.println(jdbc.getById(1L));
    }

    @Test
    void insert() {
        EvidenceDAOJdbc jdbc = new EvidenceDAOJdbc();
        Evidence evidence = new Evidence();
        evidence.setVersion(1);
        evidence.setArchived(true);
        evidence.setItemName("Quocc");
        evidence.setNotes("Note");
        evidence.setNumber("0323443");
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(2L);
        evidence.setCriminalCase(criminalCase);
        Storage storage = new Storage();
        storage.setId(1L);
        evidence.setStorage(storage);
        jdbc.insert(evidence);
        assertEquals(size+1, Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void update() {
        EvidenceDAOJdbc jdbc = new EvidenceDAOJdbc();
        Evidence evidence = new Evidence();
        evidence.setVersion(1);
        evidence.setArchived(true);
        evidence.setItemName("QuoccUpdate");
        evidence.setNotes("Note");
        evidence.setNumber("0232421");
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(2L);
        evidence.setCriminalCase(criminalCase);
        Storage storage = new Storage();
        storage.setId(1L);
        evidence.setStorage(storage);
        jdbc.insert(evidence);
        assertEquals(size, Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void delete() {
        EvidenceDAOJdbc jdbc = new EvidenceDAOJdbc();
        jdbc.delete(1L);
        assertEquals(size-1, Long.valueOf(jdbc.getAll().size()));
    }
}