package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.CriminalCase;
import com.example.criminal_evidence_management_system_sprint2.dao.ICriminalCaseDAO;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;

import java.util.List;

public class CriminalCaseDAOMem implements ICrudBase<CriminalCase, Long>, ICriminalCaseDAO {
    private List<CriminalCase> lst;

    public CriminalCaseDAOMem(List<CriminalCase> lst) {
        this.lst = lst;
    }

    @Override
    public List<CriminalCase> getAll() {
        return lst;
    }

    @Override
    public CriminalCase getById(Long aLong) {
        return lst.stream()
                .filter(i -> i.getId().equals(aLong))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CriminalCase insert(CriminalCase criminalCase) {
        if (this.getById(criminalCase.getId())==null){
            lst.add(criminalCase);
            return criminalCase;
        }
        return null;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase, Long aLong) {
        if (this.getById(criminalCase.getId()) ==null){
            lst.forEach(i -> {
                if (i.getId().equals(aLong)){
                    criminalCase.setId(aLong);
                    i = criminalCase;
                    return;
                }
            });
        }
        return criminalCase;
    }

    @Override
    public void delete(Long Long) {
        lst.removeIf(i -> i.getId().equals(Long));
    }
}
