package com.FIS.Quocdb.dao.jdbc_spring;

import com.FIS.Quocdb.entities.CriminalCase;

import java.util.List;

public interface CriminalCaseDAO {
    public void saveOrUpdate(CriminalCase criminalCase);

    public void delete(Long id);

    public CriminalCase getCriminalCase(Long id);

    public List<CriminalCase> listCriminalCases();
}
