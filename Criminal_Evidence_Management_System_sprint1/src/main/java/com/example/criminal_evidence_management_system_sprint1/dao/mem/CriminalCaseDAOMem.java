package com.example.criminal_evidence_management_system_sprint1.dao.mem;

import com.example.criminal_evidence_management_system_sprint1.core.CriminalCase;
import com.example.criminal_evidence_management_system_sprint1.dao.ICriminalCaseDAO;
import com.example.criminal_evidence_management_system_sprint1.dao.ICrudBase;

import java.util.List;

public class CriminalCaseDAOMem implements ICrudBase<CriminalCase, Integer>, ICriminalCaseDAO {
    private List<CriminalCase> lst;

    public CriminalCaseDAOMem(List<CriminalCase> lst) {
        this.lst = lst;
    }

    @Override
    public List<CriminalCase> getAll() {
        return lst;
    }

    @Override
    public CriminalCase getById(Integer integer) {
        return lst.stream()
                .filter(i -> i.getCriminalCaseId().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CriminalCase insert(CriminalCase criminalCase) {
        if (this.getById(criminalCase.getCriminalCaseId())==null){
            lst.add(criminalCase);
            return criminalCase;
        }
        return null;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase, Integer integer) {
        if (this.getById(criminalCase.getCriminalCaseId())!=null){
            lst.forEach(i -> {
                if (i.getCriminalCaseId().equals(integer)){
                    criminalCase.setCriminalCaseId(integer);
                    i = criminalCase;
                    return;
                }
            });
        }
        return criminalCase;
    }

    @Override
    public void delete(Integer integer) {
        lst.removeIf(i -> i.getCriminalCaseId().equals(integer));
    }
}
