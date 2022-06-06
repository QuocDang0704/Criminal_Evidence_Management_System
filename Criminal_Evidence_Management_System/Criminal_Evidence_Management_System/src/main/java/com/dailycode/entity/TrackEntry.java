package com.dailycode.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "track_entry")
public class TrackEntry {
    @Id
    @Column(name = "track_entry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackEntryId;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="evidence",referencedColumnName = "evidence_id", nullable=false)
    private Evidence evidence;

    @ManyToOne
    @JoinColumn(name="detective_id",referencedColumnName = "detective_id", nullable=false)
    private Detective detective;

    // TODO (Enum)
    @Column(name = "action")
    private String action;

    @Column(name = "reason")
    private String reason;
}
