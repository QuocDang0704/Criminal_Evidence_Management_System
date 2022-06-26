package fis.quocdb3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fis.quocdb3.domain.enums.TrackAction;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TrackEntry extends AbstractEntity {

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "evidence_fk", nullable = false)
    private Evidence evidence;

    @ManyToOne
    @JoinColumn(name = "detective_fk", nullable = false)
    private Detective detective;

    @Enumerated(EnumType.STRING)
    private TrackAction action;

    private String reason;
}
