package com.easysales.Repository;

import com.easysales.Domain.IEntity;
import com.easysales.UnitOfWork.IUnitOfWork;

import java.util.List;


/**
 * Created by drmiller on 03.08.2016.
 */
public abstract class RepositoryBase<T extends IEntity> implements IRepository, IUnitOfWorkRepository {
    private IUnitOfWork unitOfWork;

    protected RepositoryBase(){
        this(null);
    }

    protected RepositoryBase(IUnitOfWork unitOfWork){
        this.unitOfWork = unitOfWork;
    }

    //region IRepository<T> members
    @Override
    public IEntity get(Object key) {
        return this.findBy(key);
    }

    @Override
    public void set(Object key, IEntity entity) {
        if(this.findBy(key) == null){
            this.add(entity);
        }
        else{
            if(this.unitOfWork != null){
                this.unitOfWork.RegisterChanged(entity, this);
            }
        }
    }

    @Override
    public abstract IEntity findBy(Object key);

    @Override
    public abstract List findAll();

    @Override
    public void add(IEntity item) {
        if(unitOfWork != null){
            this.unitOfWork.RegisterAdded(item, this);
        }
    }

    @Override
    public void remove(IEntity item) {
        if(unitOfWork != null){
            this.unitOfWork.RegisterRemoved(item, this);
        }
    }

    @Override
    public void setUnitOfWork(IUnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    //endregion

    //region IUnitOfWorkRepository
    @Override
    public abstract void persistNewItem(IEntity item);

    @Override
    public abstract void persistUpdatedItem(IEntity item);

    @Override
    public abstract void persistDeletedItem(IEntity item);
    //endregion

    protected IUnitOfWork getUnitOfWork(){
        return unitOfWork;
    }
}
