package com.example.criminal_evidence_management_system_sprint2.core;

import com.example.criminal_evidence_management_system_sprint2.common.CaseStatus;
import com.example.criminal_evidence_management_system_sprint2.common.EmploymentStatus;
import com.example.criminal_evidence_management_system_sprint2.common.Rank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Detective extends AbstractEntity {
    private Person person;
    private String badgeNumber;
    private Rank rank;
    private Boolean armed = false;
    private EmploymentStatus status;
    private Set<CriminalCase> criminalCases = new HashSet<>();
    private Set<TrackEntry> trackEntries;

    @Override
    public String toString() {
        return "Detective{" +
                "person=" + person +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", rank=" + rank +
                ", armed=" + armed +
                ", status=" + status +
                ", criminalCases=" + criminalCases +
                ", trackEntries=" + trackEntries +
                '}';
    }
}
