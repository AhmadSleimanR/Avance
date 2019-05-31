package pe.isil.mghHoteles.service;

import java.util.List;

public interface BasicCrud <T, T2>{

    void create(T t);
    T update(T t);
    void delete(T t);

    List<T> findAll();
    T findById(T2 t2);
}
