package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.Evidence;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IEvidenceDAO;

import java.util.List;

public class EvidenceDAOMem implements ICrudBase<Evidence, Long>, IEvidenceDAO {
    private List<Evidence> lst;

    public EvidenceDAOMem(List<Evidence> lst) {
        this.lst = lst;
    }


    @Override
    public List<Evidence> getAll() {
        return lst;
    }

    @Override
    public Evidence getById(Long along) {
        return lst.stream()
                .filter(i -> i.getId().equals(along))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Evidence insert(Evidence evidence) {
        if (this.getById(evidence.getId()).equals(null)){
            lst.add(evidence);
            return evidence;
        }
        return null;
    }

    @Override
    public Evidence update(Evidence evidence, Long along) {
        if (this.getById(evidence.getId())!=null){
            lst.forEach(i -> {
                if (i.getId().equals(along)){
                    evidence.setId(along);
                    i = evidence;
                    return;
                }
            });
        }
        return evidence;
    }

    @Override
    public void delete(Long along) {
        lst.removeIf(i -> i.getId().equals(along));

    }
}
