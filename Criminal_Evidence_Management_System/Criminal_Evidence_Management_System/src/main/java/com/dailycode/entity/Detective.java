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
@Table(name = "detective")
public class Detective {
    @Id
    @Column(name = "detective_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detectiveId;

    @OneToOne()
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "badge_number")
    private String badgeNumber;
    // TODO (ENUM)
    @Column(name = "rank")
    private String rank;

    @Column(name = "armed")
    private Boolean armed;
    // TODO (ENUM)
    @Column(name = "status")
    private String status;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "working_detective_case",
            joinColumns = @JoinColumn(name = "detective_id"),
            inverseJoinColumns = @JoinColumn(name = "criminal_case_id"))
    private Set<CriminalCase> criminalCases;

    @JsonIgnore
    @OneToMany(
            mappedBy = "detective"
    )
    private Set<TrackEntry> trackEntries;

}
