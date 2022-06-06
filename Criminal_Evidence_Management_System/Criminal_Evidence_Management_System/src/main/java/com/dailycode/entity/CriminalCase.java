package com.dailycode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "criminal_case")
public class CriminalCase {
    @Id
    @Column(name = "criminal_case_id")
    private Integer criminalCaseId;

    @Column(name = "number")
    private String number;

    // TODO (ENUM)
    @Column(name = "type")
    private String type;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "detailed_description")
    private String detailedDescription;

    // TODO (ENUM)
    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes;

    @JsonIgnore
    @OneToMany(
            mappedBy = "criminalCase"
    )
    private Set<Evidence> evidenceSet;

    @ManyToOne
    @JoinColumn(name="detective",referencedColumnName = "detective_id", nullable=false)
    private Detective leadInvestigator;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "working_detective_case",
            joinColumns = @JoinColumn(name = "criminal_case_id"),
            inverseJoinColumns = @JoinColumn(name = "detective_id"))
    private Set<Detective> assigned;
}
