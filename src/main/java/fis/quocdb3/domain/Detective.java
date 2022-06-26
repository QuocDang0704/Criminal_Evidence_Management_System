package fis.quocdb3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fis.quocdb3.domain.enums.EmploymentStatus;
import fis.quocdb3.domain.enums.Rank;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @JsonIgnore
    @JoinTable(
            name = "working_detective_case",
            joinColumns = @JoinColumn(name = "detective_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "id"))
    private List<CriminalCase> criminalCases = new ArrayList<>();

    @OneToMany(mappedBy = "detective")
    @JsonIgnore
    private List<TrackEntry> trackEntries;

}
