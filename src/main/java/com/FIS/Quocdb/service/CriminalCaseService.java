package com.FIS.Quocdb.service;

import com.FIS.Quocdb.entities.CriminalCase;

import java.util.Set;

public interface CriminalCaseService {
    CriminalCase addCriminalCase(CriminalCase criminalCase);

    CriminalCase updateCriminalCase(CriminalCase criminalCase);

    Set<CriminalCase> getCriminalCases();

    CriminalCase getCriminalCase(Long id);

    void deleteCriminalCase(Long id);

}
