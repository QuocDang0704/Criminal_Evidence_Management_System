package com.FIS.Quocdb.service;

import com.FIS.Quocdb.entities.Storage;

import java.util.Set;

public interface StorageService {
    Storage addStorage(Storage storage);

    Storage updateStorage(Storage storage);

    Set<Storage> getStorages();

    Storage getStorage(Long id);

    void deleteStorage(Long id);
}
