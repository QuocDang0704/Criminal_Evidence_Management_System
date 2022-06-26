package fis.quocdb3.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fis.quocdb3.domain.enums.CaseStatus;
import fis.quocdb3.domain.enums.CaseType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriminalCase extends AbstractEntity{
    private String number;

    @Column(name="case_type")
    @Enumerated(EnumType.STRING)
    private CaseType type;

    private String shortDescription;
    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    private String notes;

    @OneToMany(mappedBy = "criminalCase", cascade = CascadeType.PERSIST)
    @JsonBackReference
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
