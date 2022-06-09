package com.example.criminal_evidence_management_system_sprint2.dao;

import java.util.List;

public interface ICrudBase<T, K> {
    List<T> getAll();
    T getById(K k);
    T insert(T t);
    T update(T t, K k);
}
