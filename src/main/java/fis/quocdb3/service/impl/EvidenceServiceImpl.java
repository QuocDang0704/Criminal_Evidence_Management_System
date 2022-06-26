package fis.quocdb3.service.impl;

import fis.quocdb3.domain.Evidence;
import fis.quocdb3.repository.EvidenceRepository;
import fis.quocdb3.service.CrudBase;
import fis.quocdb3.service.IEvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EvidenceServiceImpl
        implements IEvidenceService {

    @Autowired
    EvidenceRepository evidenceRepository;

    @Override
    public Evidence add(Evidence evidence) {
        return this.evidenceRepository.save(evidence);
    }

    @Override
    public Evidence update(Evidence evidence) {
        return this.evidenceRepository.save(evidence);
    }

    @Override
    public Set<Evidence> getAll() {
        return new HashSet<>(this.evidenceRepository.findAll());
    }

    @Override
    public Evidence getById(Long id) {
        return this.evidenceRepository.findById(id)
                .orElseThrow(() -> {throw new IllegalArgumentException(String.format("Not found with id: %s", id));});
    }

    @Override
    public void delete(Long id) {
        Evidence evidence = new Evidence();
        evidence.setId(id);
        this.evidenceRepository.delete(evidence);
    }
}
