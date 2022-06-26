package fis.quocdb3.service.impl;

import fis.quocdb3.domain.Storage;
import fis.quocdb3.repository.StorageRepository;
import fis.quocdb3.service.CrudBase;
import fis.quocdb3.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StorageServiceImpl
        implements IStorageService {
    @Autowired
    StorageRepository storageRepository;

    @Override
    public Storage add(Storage storage) {
        return this.storageRepository.save(storage);
    }

    @Override
    public Storage update(Storage storage) {
        return this.storageRepository.save(storage);
    }

    @Override
    public Set<Storage> getAll() {
        return new HashSet<>(this.storageRepository.findAll());
    }

    @Override
    public Storage getById(Long id) {
        return this.storageRepository.findById(id)
                .orElseThrow(() -> {throw new IllegalArgumentException(String.format("Not found with id: %s", id));});
    }

    @Override
    public void delete(Long id) {
        Storage storage = new Storage();
        storage.setId(id);
        this.storageRepository.delete(storage);
    }
}
