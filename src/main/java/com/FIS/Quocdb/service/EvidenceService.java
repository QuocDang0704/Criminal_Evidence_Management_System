package com.FIS.Quocdb.service;

import com.FIS.Quocdb.entities.Evidence;

import java.util.Set;

public interface EvidenceService {
    Evidence addEvidence(Evidence evidence);

    Evidence updateEvidence(Evidence evidence);

    Set<Evidence> getEvidences();

    Evidence getEvidence(Long id);

    void deleteEvidence(Long id);

}
