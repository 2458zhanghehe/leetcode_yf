package com.company.Shousi.WriteHashMap;

public interface MyMap {

    public void put(Object key, Object value);
    public Object get(Object key);
    public int size();
    public boolean isEmpty();

    interface Entry{
        public Object getKey();
        public Object getValue();
    }
}
