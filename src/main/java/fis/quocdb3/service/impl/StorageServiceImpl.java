package fis.quocdb3.service.impl;

import fis.quocdb3.domain.Storage;
import fis.quocdb3.repository.StorageRepository;
import fis.quocdb3.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Storage> getAll() {
        return this.storageRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
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
