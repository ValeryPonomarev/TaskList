package com.easysales.Repository;

import com.easysales.Domain.IEntity;
import com.easysales.UnitOfWork.IUnitOfWork;

import java.util.List;

/**
 * Created by drmiller on 03.08.2016.
 */
public interface IRepository<T extends IEntity> {
    T get(Object key);
    void set(Object key, T entity);
    T findBy(Object key);
    List<T> findAll();
    void add(T item);
    void remove(T item);
    void setUnitOfWork(IUnitOfWork unitOfWork);
}
