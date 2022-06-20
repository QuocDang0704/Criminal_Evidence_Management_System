package com.FIS.Quocdb.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//@SequenceGenerator(name = "seqDetectiveGen", allocationSize = 1)
//@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Evidence extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "case_fk", nullable = false)
    private CriminalCase criminalCase;

    @ManyToOne
    @JoinColumn(name = "storage_fk", nullable = false)
    private Storage storage;

    private String number;

    private String itemName;

    private String notes;

    private Boolean archived=false;

    @OneToMany(mappedBy = "evidence", cascade = CascadeType.PERSIST)
    private Set<TrackEntry> trackEntries = new HashSet<>();;

    public Evidence(CriminalCase criminalCase, Storage storage, String number, String itemName, String notes, Boolean archived) {
        this.criminalCase = criminalCase;
        this.storage = storage;
        this.number = number;
        this.itemName = itemName;
        this.notes = notes;
        this.archived = archived;
    }

    public Evidence(Long id, Integer version, LocalDateTime createAt, LocalDateTime modifiedAt, CriminalCase criminalCase, Storage storage, String number, String itemName, String notes, Boolean archived) {
        super(id, version, createAt, modifiedAt);
        this.criminalCase = criminalCase;
        this.storage = storage;
        this.number = number;
        this.itemName = itemName;
        this.notes = notes;
        this.archived = archived;
    }

    public Evidence() {
    }
}
