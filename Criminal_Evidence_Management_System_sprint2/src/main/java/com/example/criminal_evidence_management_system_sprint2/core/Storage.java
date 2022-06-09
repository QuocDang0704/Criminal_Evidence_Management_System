package com.example.criminal_evidence_management_system_sprint2.core;

import lombok.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Storage {
    private Integer storageId;
    private String name;
    private String location;
    private Set<Evidence> evidenceSet;
}
