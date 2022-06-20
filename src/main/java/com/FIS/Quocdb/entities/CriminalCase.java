package com.FIS.Quocdb.entities;

import com.FIS.Quocdb.util.CaseStatus;
import com.FIS.Quocdb.util.CaseType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@SequenceGenerator(name = "seqCriminalCaseGen", allocationSize = 1)
//@EqualsAndHashCode(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriminalCase extends AbstractEntity{
    private String number;

    @NotNull
    @Column(name="case_type")
    @Enumerated(EnumType.STRING)
    private CaseType type;

    private String shortDescription;
    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    private String notes;

    @OneToMany(mappedBy = "criminalCase", cascade = CascadeType.PERSIST)
    private Set<Evidence> evidences = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "LEAD_INVESTIGATOR", nullable = false)
    private Detective leadInvestigator;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="working_detective_case",
            joinColumns=@JoinColumn(name="case_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="detective_id", referencedColumnName="id"))
    private Set<Detective> assigned = new HashSet<>();


}
