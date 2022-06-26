package fis.quocdb3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Storage extends AbstractEntity {
    private String name;
    private String location;

    @OneToMany(mappedBy = "storage")
    @JsonIgnore
    private List<Evidence> evidenceSet = new ArrayList<>();

}
