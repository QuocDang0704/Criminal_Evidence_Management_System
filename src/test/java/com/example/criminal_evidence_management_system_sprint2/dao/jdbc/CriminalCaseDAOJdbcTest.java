package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.common.CaseStatus;
import com.example.criminal_evidence_management_system_sprint2.common.CaseType;
import com.example.criminal_evidence_management_system_sprint2.core.CriminalCase;
import com.example.criminal_evidence_management_system_sprint2.core.Detective;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CriminalCaseDAOJdbcTest {
    private Long size = null;

    @BeforeEach
    void initDataEachTest(){
        CriminalCaseDAOJdbc jdbc = new CriminalCaseDAOJdbc();
        size = Long.valueOf(jdbc.getAll().size());
    }
    @Test
    void getAll() {
        CriminalCaseDAOJdbc jdbc = new CriminalCaseDAOJdbc();
        Long size2 = Long.valueOf(jdbc.getAll().size());
        assertEquals(size, size2);
    }

    @Test
    void getById() {
        CriminalCaseDAOJdbc jdbc = new CriminalCaseDAOJdbc();
        System.out.println(jdbc.getById(2L).toString());
    }

    @Test
    void insert() {
        CriminalCaseDAOJdbc jdbc = new CriminalCaseDAOJdbc();

        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setVersion(1);
        criminalCase.setDetailedDescription("hello");
        criminalCase.setNotes("Note");
        criminalCase.setNumber("023432144");
        criminalCase.setShortDescription("test");
        criminalCase.setStatus(CaseStatus.valueOf("SUBMITTED"));
        criminalCase.setType(CaseType.valueOf("UNCATEGORIZED"));
        Detective detective  = new Detective();
        detective.setId(8L);
        criminalCase.setLeadInvestigator(detective);
        jdbc.insert(criminalCase);

        assertEquals(size+1, jdbc.getAll().size());
    }

    @Test
    void update() {
        CriminalCaseDAOJdbc jdbc = new CriminalCaseDAOJdbc();

        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setVersion(1);
        criminalCase.setDetailedDescription("hello");
        criminalCase.setNotes("Note");
        criminalCase.setNumber("023432144");
        criminalCase.setShortDescription("test");
        criminalCase.setStatus(CaseStatus.valueOf("SUBMITTED"));
        criminalCase.setType(CaseType.valueOf("UNCATEGORIZED"));
        Detective detective  = new Detective();
        detective.setId(8L);
        criminalCase.setLeadInvestigator(detective);
        jdbc.update(criminalCase, 2L);

        assertEquals(size, jdbc.getAll().size());
    }

    @Test
    void delete() {
        CriminalCaseDAOJdbc jdbc = new CriminalCaseDAOJdbc();
        jdbc.delete(2L);

        assertEquals(size-1, jdbc.getAll().size());
    }

}