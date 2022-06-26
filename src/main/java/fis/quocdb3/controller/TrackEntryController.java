package fis.quocdb3.controller;


import fis.quocdb3.domain.TrackEntry;
import fis.quocdb3.service.ITrackEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/trackEntry")
public class TrackEntryController {
    @Autowired
    ITrackEntryService trackEntryService;

    @GetMapping("/")
    public Set<TrackEntry> getTrackEntries() {
        return this.trackEntryService.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<TrackEntry> addTrackEntry(@RequestBody TrackEntry trackEntry) {
        return ResponseEntity.ok(this.trackEntryService.add(trackEntry));
    }

    @PutMapping("/")
    public TrackEntry updateTrackEntry(@RequestBody TrackEntry trackEntry) {
        return this.trackEntryService.update(trackEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteTrackEntry(@PathVariable Long id) {
        this.trackEntryService.delete(id);
    }
}
