package com.easysales.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drmiller on 03.08.2016.
 */
public final class RepositoryFactory {
    private static Map<String, Object> repositories = new HashMap<String, Object>();

    public static <TRepository extends IRepository> TRepository getRepository(String name) {
        Object repository = null;
        if (repositories.containsKey(name))
        {
            repository = repositories.get(name);
        }
        else
        {
            switch (name)
            {
                default:
                    throw new IllegalArgumentException(String.format("Repository %1$s not found!", name));
            }
        }

        return (TRepository)repository;
    }

}
