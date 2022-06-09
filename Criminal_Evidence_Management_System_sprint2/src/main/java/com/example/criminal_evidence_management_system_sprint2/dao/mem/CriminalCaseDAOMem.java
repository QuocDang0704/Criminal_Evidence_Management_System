package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.CriminalCase;
import com.example.criminal_evidence_management_system_sprint2.dao.ICriminalCaseDAO;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;

import java.util.List;

public class CriminalCaseDAOMem implements ICrudBase<CriminalCase, Integer>, ICriminalCaseDAO {
    private List<CriminalCase> lst;

    public CriminalCaseDAOMem(List<CriminalCase> lst) {
        this.lst = lst;
    }

    @Override
    public List<CriminalCase> getAll() {
        return null;
    }

    @Override
    public CriminalCase getById(Integer integer) {
        return null;
    }

    @Override
    public CriminalCase insert(CriminalCase criminalCase) {
        return null;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase, Integer integer) {
        return null;
    }
}
