package fis.quocdb3.controller;

import fis.quocdb3.domain.Storage;
import fis.quocdb3.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/storage")
@CrossOrigin("*")
public class StorageController {
    @Autowired
    IStorageService storageService;

    @GetMapping("/")
    public List<Storage> getStorages() {
        return this.storageService.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<Storage> addStorage(@RequestBody Storage storage) {
        return ResponseEntity.ok(this.storageService.add(storage));
    }

    @PutMapping("/")
    public Storage updateStorage(@RequestBody Storage storage) {
        return this.storageService.update(storage);
    }

    @DeleteMapping("/{id}")
    public void deleteStorage(@PathVariable Long id) {
        this.storageService.delete(id);
    }
}
