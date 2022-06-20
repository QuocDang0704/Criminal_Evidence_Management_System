package com.FIS.Quocdb.service.impl;

import com.FIS.Quocdb.entities.Storage;
import com.FIS.Quocdb.repository.StorageRepository;
import com.FIS.Quocdb.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageRepository storageRepository;

    @Override
    public Storage addStorage(Storage storage) {
        return this.storageRepository.save(storage);
    }

    @Override
    public Storage updateStorage(Storage storage) {
        return this.storageRepository.save(storage);
    }

    @Override
    public Set<Storage> getStorages() {
        return new HashSet<>(this.storageRepository.findAll());
    }

    @Override
    public Storage getStorage(Long id) {
        return this.storageRepository.findById(id).get();
    }

    @Override
    public void deleteStorage(Long id) {
        Storage storage = new Storage();
        storage.setId(id);
        this.storageRepository.delete(storage);
    }
}
