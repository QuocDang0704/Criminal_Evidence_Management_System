package fis.quocdb3.service;

import java.util.Set;

public interface CrudBase<T, K> {
    T add(T t);

    T update(T t);

    Set<T> getAll();

    T getById(K k);

    void delete(K k);
}
