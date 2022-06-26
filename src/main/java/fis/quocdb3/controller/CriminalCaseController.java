package fis.quocdb3.controller;

import fis.quocdb3.domain.CriminalCase;
import fis.quocdb3.service.ICriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/criminalCase")
@CrossOrigin("*")
public class CriminalCaseController {

    @Autowired
    private ICriminalCaseService criminalCaseService;

    @PostMapping("/")
    public ResponseEntity<CriminalCase> addCriminalCase(@RequestBody CriminalCase criminalCase) {
        CriminalCase criminalCase1 = this.criminalCaseService.add(criminalCase);
        return ResponseEntity.ok(criminalCase1);
    }

    @PutMapping("/")
    public CriminalCase updateCriminalCase(@RequestBody CriminalCase criminalCase) {
        return this.criminalCaseService.update(criminalCase);
    }

    @DeleteMapping("/{id}")
    public void deleteCriminalCase(@PathVariable Long id) {
        this.criminalCaseService.delete(id);
    }

    @GetMapping("/")
    public List<CriminalCase> getCriminalCases() {
        return this.criminalCaseService.getAll();
    }

}
