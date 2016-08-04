package com.easysales.UnitOfWork;

import com.easysales.Domain.IEntity;
import com.easysales.Repository.IUnitOfWorkRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by drmiller on 03.08.2016.
 */
public class UnitOfWork implements IUnitOfWork {
    private UUID key;
    private List<Operation> operations;

    public UnitOfWork(){
        this.key = UUID.randomUUID();
        this.operations = new ArrayList<>();
    }

    private class Operation{

        public Operation(IEntity entity, IUnitOfWorkRepository repository, TransactionType type){
            this(entity, new Date(), repository, type);
        }

        public Operation(IEntity entity, Date processDate, IUnitOfWorkRepository repository, TransactionType type){
            this.entity = entity;
            this.processDate = processDate;
            this.repository = repository;
            this.type = type;
        }

        private IEntity entity;
        private Date processDate;
        private IUnitOfWorkRepository repository;
        private TransactionType type;

        public IEntity getEntity() {
            return entity;
        }

        public void setEntity(IEntity entity) {
            this.entity = entity;
        }

        public Date getProcessDate() {
            return processDate;
        }

        public void setProcessDate(Date processDate) {
            this.processDate = processDate;
        }

        public IUnitOfWorkRepository getRepository() {
            return repository;
        }

        public void setRepository(IUnitOfWorkRepository repository) {
            this.repository = repository;
        }

        public TransactionType getType() {
            return type;
        }

        public void setType(TransactionType type) {
            this.type = type;
        }
    }

    @Override
    public void RegisterAdded(IEntity entity, IUnitOfWorkRepository repository) {
        operations.add(new Operation(entity, repository, TransactionType.Insert));
    }

    @Override
    public void RegisterChanged(IEntity entity, IUnitOfWorkRepository repository) {
        operations.add(new Operation(entity, repository, TransactionType.Update));
    }

    @Override
    public void RegisterRemoved(IEntity entity, IUnitOfWorkRepository repository) {
        operations.add(new Operation(entity, repository, TransactionType.Delete));
    }

    @Override
    public void Commit() {
        for (Operation operation: operations ) {
            switch (operation.type){
                case Insert:
                    operation.repository.persistNewItem(operation.entity);
                    break;
                case Delete:
                    operation.repository.persistDeletedItem(operation.entity);
                    break;
                case Update:
                    operation.repository.persistUpdatedItem(operation.entity);
                    break;
            }
        }
        operations.clear();
        key = UUID.randomUUID();
    }

    @Override
    public Object getKey() {
        return this.key;
    }
}
