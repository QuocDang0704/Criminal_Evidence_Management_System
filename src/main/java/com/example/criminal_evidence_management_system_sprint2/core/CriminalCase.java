package com.example.criminal_evidence_management_system_sprint2.core;

import com.example.criminal_evidence_management_system_sprint2.common.CaseStatus;
import com.example.criminal_evidence_management_system_sprint2.common.CaseType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CriminalCase extends AbstractEntity{
    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private Set<Evidence> evidences = new HashSet<>();
    private Detective leadInvestigator;
    private Set<Detective> assigned = new HashSet<>();
}
