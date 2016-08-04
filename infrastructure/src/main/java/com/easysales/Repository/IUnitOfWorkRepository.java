package com.easysales.Repository;

import com.easysales.Domain.IEntity;

/**
 * Created by drmiller on 03.08.2016.
 */
public interface IUnitOfWorkRepository {
    void persistNewItem(IEntity item);
    void persistUpdatedItem(IEntity item);
    void persistDeletedItem(IEntity item);
}
