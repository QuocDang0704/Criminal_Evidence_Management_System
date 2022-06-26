package fis.quocdb3.controller;

import fis.quocdb3.domain.Detective;
import fis.quocdb3.service.IDetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/detective")
@CrossOrigin("*")
public class DetectiveController {
    @Autowired
    IDetectiveService detectiveService;

    @GetMapping("/")
    public Set<Detective> getDetectives() {
        return this.detectiveService.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<Detective> addDetective(@RequestBody Detective detective) {
        return ResponseEntity.ok(this.detectiveService.add(detective));
    }

    @PutMapping("/")
    public Detective updateDetective(@RequestBody Detective detective) {
        return this.detectiveService.update(detective);
    }

    @DeleteMapping("/{id}")
    public void deleteDetective(@PathVariable Long id) {
         this.detectiveService.delete(id);
    }

}
