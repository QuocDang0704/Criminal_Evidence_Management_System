package fis.quocdb3.controller;

import fis.quocdb3.domain.Detective;
import fis.quocdb3.domain.Evidence;
import fis.quocdb3.service.IEvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceController {
    @Autowired
    IEvidenceService evidenceService;

    @GetMapping("/")
    public Set<Evidence> getEvidences() {
        return this.evidenceService.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<Evidence> addEvidence(@RequestBody Evidence evidence) {
        return ResponseEntity.ok(this.evidenceService.add(evidence));
    }

    @PutMapping("/")
    public Evidence updateEvidence(@RequestBody Evidence evidence) {
        return this.evidenceService.update(evidence);
    }

    @DeleteMapping("/{id}")
    public void deleteEvidence(@PathVariable Long id) {
        this.evidenceService.delete(id);
    }
}
