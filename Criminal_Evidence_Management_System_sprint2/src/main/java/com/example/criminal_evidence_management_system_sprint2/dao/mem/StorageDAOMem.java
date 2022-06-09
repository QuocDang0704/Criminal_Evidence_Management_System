package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.Storage;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IStorageDAO;

import java.util.List;

public class StorageDAOMem implements ICrudBase<Storage, Integer>, IStorageDAO {
    private List<Storage> lst;

    public StorageDAOMem(List<Storage> lst) {
        this.lst = lst;
    }

    @Override
    public List<Storage> getAll() {
        return null;
    }

    @Override
    public Storage getById(Integer integer) {
        return null;
    }

    @Override
    public Storage insert(Storage storage) {
        return null;
    }

    @Override
    public Storage update(Storage storage, Integer integer) {
        return null;
    }
}
