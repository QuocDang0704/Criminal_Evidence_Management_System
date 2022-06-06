package com.dailycode.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "evidence")
public class Evidence {
    @Id
    @Column(name = "evidence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer evidenceId;

    @ManyToOne
    @JoinColumn(name="criminal_case",referencedColumnName = "criminal_case_id", nullable=false)
    private CriminalCase criminalCase;

    @ManyToOne
    @JoinColumn(name="storage",referencedColumnName = "storage_id", nullable=false)
    private Storage storage;

    @Column(name = "number")
    private String number;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "notes")
    private String notes;

    @Column(name = "archived")
    private Boolean archived;

    @OneToMany(
            mappedBy = "evidence"
    )
    private Set<TrackEntry> trackEntries;

}
