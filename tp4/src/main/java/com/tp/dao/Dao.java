package com.tp.dao;

import java.util.Collection;

public interface Dao<T> {
    Long create(T obj);
    boolean delete(long id);
    Collection<T> getAll();
    T getByPk(long id);
    boolean update(T obj);
}