package com.example.criminal_evidence_management_system_sprint1.dao.mem;

import com.example.criminal_evidence_management_system_sprint1.core.Storage;
import com.example.criminal_evidence_management_system_sprint1.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint1.dao.IStorageDAO;

import java.util.List;

public class StorageDAOMem implements ICrudBase<Storage, Integer>, IStorageDAO {
    private List<Storage> lst;

    public StorageDAOMem(List<Storage> lst) {
        this.lst = lst;
    }

    @Override
    public List<Storage> getAll() {
        return lst;
    }

    @Override
    public Storage getById(Integer integer) {
        return lst.stream()
                .filter(i -> i.getStorageId().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Storage insert(Storage storage) {
        if (this.getById(storage.getStorageId()).equals(null)){
            lst.add(storage);
            return storage;
        }
        return null;
    }

    @Override
    public Storage update(Storage storage, Integer integer) {
        if (this.getById(storage.getStorageId())!=null){
            lst.forEach(i -> {
                if (i.getStorageId().equals(integer)){
                    storage.setStorageId(integer);
                    i = storage;
                    return;
                }
            });
        }
        return storage;
    }

    @Override
    public void delete(Integer integer) {
        lst.removeIf(i -> i.getStorageId().equals(integer));
    }
}
