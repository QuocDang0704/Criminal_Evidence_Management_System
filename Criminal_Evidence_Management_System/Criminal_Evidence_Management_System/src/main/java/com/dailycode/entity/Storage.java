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
@Table(name = "storage")
public class Storage {
    @Id
    @Column(name = "storage_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storageId;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @JsonIgnore
    @OneToMany(
            mappedBy = "storage"
    )
    private Set<Evidence> evidenceSet;
}
