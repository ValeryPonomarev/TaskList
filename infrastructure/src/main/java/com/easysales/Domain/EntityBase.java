package com.easysales.Domain;

/**
 * Created by drmiller on 03.08.2016.
 */
public abstract class EntityBase implements IEntity {
    private Object key;

    public EntityBase(){
        this(null);
    }

    public EntityBase(Object key) {
        this.key = key;
    }

    public Object getKey() {
        return key;
    }

    @Override
    public boolean equals(Object entity) {
        return entity != null
                && entity instanceof EntityBase
                && this.key.equals(((EntityBase) entity).key);
    }
}
