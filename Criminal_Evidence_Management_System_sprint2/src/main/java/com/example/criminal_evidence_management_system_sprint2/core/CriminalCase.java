package com.example.criminal_evidence_management_system_sprint2.core;

import com.example.criminal_evidence_management_system_sprint2.common.CaseStatus;
import com.example.criminal_evidence_management_system_sprint2.common.CaseType;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CriminalCase {
    private Integer criminalCaseId;
    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private Set<Evidence> evidenceSet;
    private Detective leadInvestigator;
    private Set<Detective> assigned;
}
