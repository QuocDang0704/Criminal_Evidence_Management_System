package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.Detective;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IDetectiveDAO;

import java.util.List;

public class DetectiveDAOMem implements ICrudBase<Detective, Integer>, IDetectiveDAO {
    private List<Detective> lst;

    public DetectiveDAOMem(List<Detective> lst) {
        this.lst = lst;
    }

    @Override
    public List<Detective> getAll() {
        return null;
    }

    @Override
    public Detective getById(Integer integer) {
        return null;
    }

    @Override
    public Detective insert(Detective detective) {
        return null;
    }

    @Override
    public Detective update(Detective detective, Integer integer) {
        return null;
    }
}
