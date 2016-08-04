package com.easysales.UnitOfWork;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drmiller on 03.08.2016.
 */
public enum TransactionType {
    Insert(1), Update(2), Delete(3);

    private int value;
    private static Map map = new HashMap<>();

    private TransactionType(int value)
    {
        this.value = value;
    }

    static {
        for(TransactionType callType : TransactionType.values())
        {
            map.put(callType.value, callType);
        }
    }

    public static TransactionType valueOf(int callType)
    {
        if(map.containsKey(callType)) {
            return (TransactionType) map.get(callType);
        }
        else
            return (TransactionType) map.get(1);
    }

    public int getValue()
    {
        return value;
    }
}
