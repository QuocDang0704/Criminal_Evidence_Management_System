package fis.quocdb3.controller;

import fis.quocdb3.domain.Detective;
import fis.quocdb3.domain.Evidence;
import fis.quocdb3.service.IEvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/evidence")
@CrossOrigin("*")
public class EvidenceController {
    @Autowired
    IEvidenceService evidenceService;

    @GetMapping("/")
    @PreAuthorize("hasAuthority('JUNIOR')")
    public List<Evidence> getEvidences() {
        return this.evidenceService.getAll();
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('JUNIOR') or hasAuthority('SENIOR') or hasAuthority('INSPECTOR')")
    public ResponseEntity<Evidence> addEvidence(@RequestBody Evidence evidence) {
        return ResponseEntity.ok(this.evidenceService.add(evidence));
    }

    @PutMapping("/")
    @PreAuthorize("hasAuthority('JUNIOR') or hasAuthority('SENIOR') or hasAuthority('INSPECTOR')")
    public Evidence updateEvidence(@RequestBody Evidence evidence) {
        return this.evidenceService.update(evidence);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('JUNIOR') or hasAuthority('SENIOR') or hasAuthority('INSPECTOR')")
    public void deleteEvidence(@PathVariable Long id) {
        this.evidenceService.delete(id);
    }
}
