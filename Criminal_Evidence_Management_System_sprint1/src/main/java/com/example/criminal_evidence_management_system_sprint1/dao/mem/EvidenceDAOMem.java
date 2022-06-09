package com.example.criminal_evidence_management_system_sprint1.dao.mem;

import com.example.criminal_evidence_management_system_sprint1.core.Evidence;
import com.example.criminal_evidence_management_system_sprint1.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint1.dao.IEvidenceDAO;

import java.util.List;

public class EvidenceDAOMem implements ICrudBase<Evidence, Integer>, IEvidenceDAO {
    private List<Evidence> lst;

    public EvidenceDAOMem(List<Evidence> lst) {
        this.lst = lst;
    }


    @Override
    public List<Evidence> getAll() {
        return lst;
    }

    @Override
    public Evidence getById(Integer integer) {
        return lst.stream()
                .filter(i -> i.getEvidenceId().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Evidence insert(Evidence evidence) {
        if (this.getById(evidence.getEvidenceId()).equals(null)){
            lst.add(evidence);
            return evidence;
        }
        return null;
    }

    @Override
    public Evidence update(Evidence evidence, Integer integer) {
        if (this.getById(evidence.getEvidenceId())!=null){
            lst.forEach(i -> {
                if (i.getEvidenceId().equals(integer)){
                    evidence.setEvidenceId(integer);
                    i = evidence;
                    return;
                }
            });
        }
        return evidence;
    }

    @Override
    public void delete(Integer integer) {
        lst.removeIf(i -> i.getEvidenceId().equals(integer));

    }
}
