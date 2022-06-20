package com.FIS.Quocdb.controller;

import com.FIS.Quocdb.entities.Evidence;
import com.FIS.Quocdb.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/evidence")
@CrossOrigin("*")
public class EvidenceController {
    @Autowired
    EvidenceService evidenceService;

    @GetMapping("/")
    public Set<Evidence> getEvidences() {
        return this.evidenceService.getEvidences();
    }

    @PostMapping("/")
    public ResponseEntity<Evidence> addEvidence(@RequestBody Evidence evidence) {
        return ResponseEntity.ok(this.evidenceService.addEvidence(evidence));
    }

    @PutMapping("/")
    public Evidence updateEvidence(@RequestBody Evidence evidence) {
        return this.evidenceService.updateEvidence(evidence);
    }

    @DeleteMapping("/{id}")
    public void deleteEvidence(@PathVariable Long id) {
        this.evidenceService.deleteEvidence(id);
    }
}
