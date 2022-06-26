package fis.quocdb3.domain;

import fis.quocdb3.domain.enums.EmploymentStatus;
import fis.quocdb3.domain.enums.Rank;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Detective extends AbstractEntity {

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
            name = "working_detective_case",
            joinColumns = @JoinColumn(name = "detective_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "id"))
    private Set<CriminalCase> criminalCases = new HashSet<>();

    @OneToMany(mappedBy = "detective")
    private Set<TrackEntry> trackEntries;

}
