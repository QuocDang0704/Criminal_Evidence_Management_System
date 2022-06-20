package com.FIS.Quocdb.controller;

import com.FIS.Quocdb.entities.CriminalCase;
import com.FIS.Quocdb.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/criminalCase")
@CrossOrigin("*")
public class CriminalCaseController {

    @Autowired
    private CriminalCaseService criminalCaseService;

    @PostMapping("/")
    public ResponseEntity<CriminalCase> addCriminalCase(@RequestBody CriminalCase criminalCase) {
        CriminalCase criminalCase1 = this.criminalCaseService.addCriminalCase(criminalCase);
        return ResponseEntity.ok(criminalCase1);
    }

    @GetMapping("/")
    public Set<CriminalCase> getCriminalCases() {
        return this.criminalCaseService.getCriminalCases();
    }
}
