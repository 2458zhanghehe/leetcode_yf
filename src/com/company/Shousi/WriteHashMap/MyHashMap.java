package com.company.Shousi.WriteHashMap;

public class MyHashMap implements MyMap{

    private Entry[] table;
    private int size = 0;

    public MyHashMap(){
        this(16);  //调用有参的构造方法
    }

    public MyHashMap(int capacity){
        table = new Entry[capacity];
    }

    class Entry implements MyMap.Entry {
        final Object key;
        Object value;
        Entry next;
        int hash;

        public Entry(Object key, Object value, Entry next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            if(next != null){
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        ", next=" + next +
                        ", hash=" + hash +
                        '}';
            }else {
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        ", hash=" + hash +
                        '}';
            }
        }
    }


    @Override
    public void put(Object key, Object value) {
        if(key == null){
            table[0] = new Entry(null,value,null,-1);
        }

        //1.计算key哈希码
        int hash = key.hashCode();

        //2.根据哈希码计算存储位置
        int index = hash & (table.length - 1);

        //3.存到指定的位置
        if(table[index] == null){
            size++;
            table[index] = new Entry(key, value, null, hash);
        }else {
            Entry entry = table[index];
            while(entry != null){
                //注意：同一个链表上的hash不一定相等（高位自由）
                if(entry.hash == hash && entry.getKey().equals(key)){
                    //key已存在，覆盖
                   entry.value = value;
                   return;
                }
                entry = entry.next;
            }
            //key不存在
            size++;
            table[index] = new Entry(key, value, table[index], hash);
        }
    }

    @Override
    public Object get(Object key) {
        if(key == null){
            return table[0];
        }

        int hash = key.hashCode();

        int index = hash & (table.length - 1);

        if(table[index] == null){
            return null;
        }
        Entry entry = table[index];
        while(entry != null){
            if(entry.hash == hash && key.equals(entry.key)){
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
