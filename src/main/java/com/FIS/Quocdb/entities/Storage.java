package com.FIS.Quocdb.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.HashSet;
import java.util.Set;

//@SequenceGenerator(name = "seqStorageGen", allocationSize = 1)
//@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Storage extends AbstractEntity {
    private String name;
    private String location;

    @OneToMany(mappedBy = "storage")
    private Set<Evidence> evidenceSet = new HashSet<>();

}
