package com.FIS.Quocdb.entities;

import com.FIS.Quocdb.util.EmploymentStatus;
import com.FIS.Quocdb.util.Rank;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@SequenceGenerator(name = "seqDetectiveGen", allocationSize = 1)
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Detective extends AbstractEntity{

    @NotNull
    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column(unique = true, nullable = false)
    private String badgeNumber;

    @Enumerated(EnumType.STRING)
    private Rank rank;


    private Boolean armed = false;

    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="working_detective_case",
            joinColumns=@JoinColumn(name="detective_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="case_id", referencedColumnName="id"))
    private Set<CriminalCase> criminalCases = new HashSet<>();

    @OneToMany(mappedBy = "detective")
    private Set<TrackEntry> trackEntries;



    public Detective() {
        super();
    }

}
