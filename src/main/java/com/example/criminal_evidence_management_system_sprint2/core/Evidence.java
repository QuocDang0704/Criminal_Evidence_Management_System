package com.example.criminal_evidence_management_system_sprint2.core;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Evidence extends AbstractEntity{
    private CriminalCase criminalCase;
    private Storage storage;
    private String number;
    private String itemName;
    private String notes;
    private Boolean archived;
    private Set<TrackEntry> trackEntries = new HashSet<>();
}
