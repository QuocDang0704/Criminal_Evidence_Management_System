package fis.quocdb3.service;

import java.util.List;

public interface CrudBase<T, K> {
    T add(T t);

    T update(T t);

    List<T> getAll();

    T getById(K k);

    void delete(K k);
}
