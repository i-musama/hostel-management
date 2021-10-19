package com.example.hostelmanagemant.services;

import java.util.Set;

public interface CRUDService<T, ID>{
    T findById(ID id);

    T save(T object);

    Set<T> findAll();

    void deleteById(ID id);


    void delete(T obj);
}
