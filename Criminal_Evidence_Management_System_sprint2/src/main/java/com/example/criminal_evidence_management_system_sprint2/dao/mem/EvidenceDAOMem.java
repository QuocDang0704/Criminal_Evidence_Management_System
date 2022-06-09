package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.Evidence;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IEvidenceDAO;

import java.util.List;

public class EvidenceDAOMem implements ICrudBase<Evidence, Integer>, IEvidenceDAO {
    private List<Evidence> lst;

    public EvidenceDAOMem(List<Evidence> lst) {
        this.lst = lst;
    }


    @Override
    public List<Evidence> getAll() {
        return null;
    }

    @Override
    public Evidence getById(Integer integer) {
        return null;
    }

    @Override
    public Evidence insert(Evidence evidence) {
        return null;
    }

    @Override
    public Evidence update(Evidence evidence, Integer integer) {
        return null;
    }
}
