package tasos.ass_3.services;

import tasos.ass_3.models.Franchise;

import java.util.Collection;

public interface CrudService <T, ID> {
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);
    boolean exists(ID id);
}