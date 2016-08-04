package com.easysales.UnitOfWork;

import com.easysales.Domain.IEntity;
import com.easysales.Repository.IUnitOfWorkRepository;

/**
 * Created by drmiller on 03.08.2016.
 */
public interface IUnitOfWork {
    void RegisterAdded(IEntity entity, IUnitOfWorkRepository repository);
    void RegisterChanged(IEntity entity, IUnitOfWorkRepository repository);
    void RegisterRemoved(IEntity entity, IUnitOfWorkRepository repository);
    void Commit();
    Object getKey();
}
