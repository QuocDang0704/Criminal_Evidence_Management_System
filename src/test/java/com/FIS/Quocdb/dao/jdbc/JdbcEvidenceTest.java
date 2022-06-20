package com.FIS.Quocdb.dao.jdbc;

import com.FIS.Quocdb.entities.CriminalCase;
import com.FIS.Quocdb.entities.Evidence;
import com.FIS.Quocdb.entities.Storage;
import org.junit.jupiter.api.Test;

class JdbcEvidenceTest {

    JdbcEvidence jdbcEvidence = new JdbcEvidence();

    @Test
    void insert() {
        Evidence evidence = new Evidence();
        evidence.setVersion(1);
        evidence.setArchived(true);
        evidence.setItemName("quocdb ");
        evidence.setNotes("note 32423");
        evidence.setNumber("034234");
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(3L);
        evidence.setCriminalCase(criminalCase);
        Storage storage = new Storage();
        storage.setId(1L);
        evidence.setStorage(storage);
        jdbcEvidence.insert(evidence);
        System.out.println("Done");
    }

    @Test
    void update() {
        Evidence evidence = new Evidence();
        evidence.setVersion(1);
        evidence.setArchived(true);
        evidence.setItemName("Update");
        evidence.setNotes("Note Update");
        evidence.setNumber("042352");
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(3L);
        evidence.setCriminalCase(criminalCase);
        Storage storage = new Storage();
        storage.setId(1L);
        evidence.setStorage(storage);
        evidence.setId(1L);
        jdbcEvidence.update(evidence);
        System.out.println("Done");
    }

    @Test
    void delete() {
        jdbcEvidence.delete(1L);
    }

    @Test
    void selectAll() {
        System.out.println(jdbcEvidence.selectAll());
    }

    @Test
    void selectById() {
        System.out.println(jdbcEvidence.selectById(1L));
    }

}