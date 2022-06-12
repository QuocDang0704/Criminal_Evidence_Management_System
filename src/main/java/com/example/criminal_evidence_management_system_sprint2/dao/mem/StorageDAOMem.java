package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.Storage;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IStorageDAO;

import java.util.List;

public class StorageDAOMem implements ICrudBase<Storage, Long>, IStorageDAO {
    private List<Storage> lst;

    public StorageDAOMem(List<Storage> lst) {
        this.lst = lst;
    }

    @Override
    public List<Storage> getAll() {
        return lst;
    }

    @Override
    public Storage getById(Long along) {
        return lst.stream()
                .filter(i -> i.getId().equals(along))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Storage insert(Storage storage) {
        if (this.getById(storage.getId()).equals(null)){
            lst.add(storage);
            return storage;
        }
        return null;
    }

    @Override
    public Storage update(Storage storage, Long along) {
        if (this.getById(storage.getId())!=null){
            lst.forEach(i -> {
                if (i.getId().equals(along)){
                    storage.setId(along);
                    i = storage;
                    return;
                }
            });
        }
        return storage;
    }

    @Override
    public void delete(Long along) {
        lst.removeIf(i -> i.getId().equals(along));
    }
}
