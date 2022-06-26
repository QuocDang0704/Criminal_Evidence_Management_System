package fis.quocdb3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @JsonIgnore
    private List<TrackEntry> trackEntries = new ArrayList<>();

}
