package com.example.criminal_evidence_management_system_sprint2.core;

import com.example.criminal_evidence_management_system_sprint2.common.CaseStatus;
import com.example.criminal_evidence_management_system_sprint2.common.Rank;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Detective {
    private Integer detectiveId;
    private Person person;
    private String badgeNumber;
    private Rank rank;
    private Boolean armed;
    private CaseStatus status;
    private Set<TrackEntry> trackEntries;

}
