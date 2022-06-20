package com.FIS.Quocdb.service.impl;

import com.FIS.Quocdb.entities.Evidence;
import com.FIS.Quocdb.repository.EvidenceRepository;
import com.FIS.Quocdb.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    @Autowired
    EvidenceRepository evidenceRepository;

    @Override
    public Evidence addEvidence(Evidence evidence) {
        return this.evidenceRepository.save(evidence);
    }

    @Override
    public Evidence updateEvidence(Evidence evidence) {
        return this.evidenceRepository.save(evidence);
    }

    @Override
    public Set<Evidence> getEvidences() {
        return new HashSet<>(this.evidenceRepository.findAll());
    }

    @Override
    public Evidence getEvidence(Long id) {
        return this.evidenceRepository.findById(id).get();
    }

    @Override
    public void deleteEvidence(Long id) {
        Evidence evidence = new Evidence();
        evidence.setId(id);
        this.evidenceRepository.delete(evidence);
    }
}
