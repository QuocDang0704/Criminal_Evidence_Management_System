package fis.quocdb3.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Evidence extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "case_fk", nullable = false)
    private CriminalCase criminalCase;

    @ManyToOne
    @JoinColumn(name = "storage_fk", nullable = false)
    private Storage storage;

    private String number;

    private String itemName;

    private String notes;

    private Boolean archived=false;

    @OneToMany(mappedBy = "evidence", cascade = CascadeType.PERSIST)
    private Set<TrackEntry> trackEntries = new HashSet<>();;

}
