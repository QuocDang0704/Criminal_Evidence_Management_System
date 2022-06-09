package com.example.criminal_evidence_management_system_sprint2.core;

import com.example.criminal_evidence_management_system_sprint2.common.TrackAction;
import lombok.*;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TrackEntry {
    private Integer trackEntryId;
    private LocalDateTime date;
    private Evidence evidence;
    private Detective detective;
    private TrackAction action;
    private String reason;
}
