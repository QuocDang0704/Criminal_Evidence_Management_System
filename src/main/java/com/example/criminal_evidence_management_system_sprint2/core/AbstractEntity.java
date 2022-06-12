package com.example.criminal_evidence_management_system_sprint2.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class AbstractEntity implements Serializable {
    private Long id;

    private Integer version;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
