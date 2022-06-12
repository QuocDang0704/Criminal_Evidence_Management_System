package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.common.TrackAction;
import com.example.criminal_evidence_management_system_sprint2.core.Detective;
import com.example.criminal_evidence_management_system_sprint2.core.Evidence;
import com.example.criminal_evidence_management_system_sprint2.core.TrackEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TrackEntryDAOJdbcTest {
    private Long size = null;

    @BeforeEach
    void initDataEachTest(){
        TrackEntryDAOJdbc jdbc = new TrackEntryDAOJdbc();
        size = Long.valueOf(jdbc.getAll().size());
    }

    @Test
    void getAll() {
        TrackEntryDAOJdbc jdbc = new TrackEntryDAOJdbc();
        jdbc.getAll().forEach(i -> System.out.println(i.toString()));
        assertEquals(size,Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void getById() {
        TrackEntryDAOJdbc jdbc = new TrackEntryDAOJdbc();
        System.out.println(jdbc.getById(1L));
    }

    @Test
    void insert() {
        TrackEntryDAOJdbc jdbc = new TrackEntryDAOJdbc();
        TrackEntry trackEntry = new TrackEntry();
        trackEntry.setVersion(1);
        trackEntry.setCreateAt(LocalDateTime.now());
        trackEntry.setModifiedAt(LocalDateTime.now());
        trackEntry.setAction(TrackAction.valueOf("RETREVED"));
        Detective detective = new Detective();
        detective.setId(8L);
        trackEntry.setDetective(detective);
        Evidence evidence = new Evidence();
        evidence.setId(1L);
        trackEntry.setEvidence(evidence);
        trackEntry.setDate(LocalDateTime.now());
        jdbc.insert(trackEntry);
        assertEquals(size+1L, Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void update() {
        TrackEntryDAOJdbc jdbc = new TrackEntryDAOJdbc();
        TrackEntry trackEntry = new TrackEntry();
        trackEntry.setVersion(1);
        trackEntry.setCreateAt(LocalDateTime.now());
        trackEntry.setModifiedAt(LocalDateTime.now());
        trackEntry.setAction(TrackAction.valueOf("RETREVED"));
        Detective detective = new Detective();
        detective.setId(8L);
        trackEntry.setDetective(detective);
        Evidence evidence = new Evidence();
        evidence.setId(1L);
        trackEntry.setEvidence(evidence);
        trackEntry.setDate(LocalDateTime.now());
        jdbc.insert(trackEntry);
        assertEquals(size, Long.valueOf(jdbc.getAll().size()));
    }

    @Test
    void delete() {
        TrackEntryDAOJdbc jdbc = new TrackEntryDAOJdbc();
        jdbc.delete(1L);
        assertEquals(size-1L, Long.valueOf(jdbc.getAll().size()));
    }
}