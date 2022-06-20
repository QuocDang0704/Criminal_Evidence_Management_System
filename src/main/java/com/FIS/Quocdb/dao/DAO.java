package com.FIS.Quocdb.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> getAll();

    Optional<T> get(Long id);

    void save(T t);

    void update(T t);

    void delete(T t);

    void deleteId(Long id);
}
