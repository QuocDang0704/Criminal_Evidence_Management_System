package com.FIS.Quocdb.repository;

import com.FIS.Quocdb.FIS_Quocdb;
import com.FIS.Quocdb.entities.CriminalCase;
import com.FIS.Quocdb.util.CaseStatus;
import com.FIS.Quocdb.util.CaseType;
import com.FIS.Quocdb.entities.Detective;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = FIS_Quocdb.class)
class CriminalCaseRepositoryTest {
    @Autowired
    CriminalCaseRepository criminalCaseRepository;

    @Test
    public void testFindById() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        CriminalCase result = this.criminalCaseRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), result.getId());
    }

    @Test
    public void testSave() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        CriminalCase found = this.criminalCaseRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), found.getId());
    }


    @Test
    public void testDeleteById() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        this.criminalCaseRepository.deleteById(employee.getId());
        List<CriminalCase> result = new ArrayList<>(this.criminalCaseRepository.findAll());
        assertEquals(result.size(), 1);
    }
    @Test
    public void testFindAll() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        List<CriminalCase> result = new ArrayList<>(this.criminalCaseRepository.findAll());
        assertEquals(result.size(), 2);
    }

    private CriminalCase getCriminalCase() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCreateAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setVersion(2);
        criminalCase.setDetailedDescription("ádjajds");
        criminalCase.setNotes("notesne");
        criminalCase.setNumber("1231231");
        criminalCase.setShortDescription("7712372");
        criminalCase.setStatus(CaseStatus.valueOf("SUBMITTED"));
        criminalCase.setType(CaseType.valueOf("UNCATEGORIZED"));
        Detective person = new Detective();
        person.setId(3L);
        criminalCase.setLeadInvestigator(person);
        return criminalCase;
    }

}